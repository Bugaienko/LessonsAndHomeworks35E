package lesson_50.exceptions;
/*
@date 15.11.2023
@author Sergey Bugaienko
*/

import java.net.MalformedURLException;
import java.net.URL;

public class ExceptionExample {
    public static void main(String[] args) {

        /*
        Ошибки компиляции.
        String str = "Hello"
        int a = "Java";
         */


//        System.out.println(1 / 0); // java.lang.ArithmeticException
        int[] array = {1, 2, 4};
        // array[10] = 10; // java.lang.ArrayIndexOutOfBoundsException

        String str = null;
        // str.length(); //java.lang.NullPointerException


         /*
        try {
            //код, который может вызвать исключение
        } catch (ExceptionType name) {
            //код обработки исключения
        } finally {
            //код, который выполнится в любом случае (при возникновении и при отсутствии исключения )
        }
         */

        String string = "1F";
        int integer;
//        integer = Integer.parseInt(string); // java.lang.NumberFormatException


        try {
            integer = Integer.parseInt(string); // java.lang.NumberFormatException
            System.out.println("Try end");

        } catch (NumberFormatException exception) {
            exception.printStackTrace();
            integer = 0;

        } finally {

            System.out.println("Блок finally");
        }

        System.out.println("integer: " + integer);
        System.out.println("Продолжение выполнения программы");

        String url = getUrlString();

        System.out.println("Пытаемся открыть страницу: " + url);

        String url2 = null;
        try {
            url2 = getUrlString2();
        } catch (MalformedURLException e) {
            System.out.println("Неверный формат адреса");
            System.out.println(e.toString());
        }

        System.out.println("Пытаемся открыть страницу 2: " + url2);


    }

    public static String getUrlString(){

        URL myUrl = null;
        String defaultUrlStr = "https://google.com";

        try {
            myUrl = new URL(defaultUrlStr);
            myUrl = new URL("htps://example.com");
        } catch (MalformedURLException exception) {
            System.out.println("Неверный формат URL " + exception.getMessage());
        }
        return myUrl.toString();
    }

    public static String getUrlString2() throws MalformedURLException {

        URL myUrl = null;
        String defaultUrlStr = "https://google.com";


            myUrl = new URL(defaultUrlStr);
            myUrl = new URL("htts://example.com");

        return myUrl.toString();
    }
}
