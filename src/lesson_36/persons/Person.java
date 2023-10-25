package lesson_36.persons;
/*
@date 23.10.2023
@author Sergey Bugaienko
*/

import java.util.Arrays;

public class Person {
    private String email;
    private String password;

    public Person(String email, String password) {
        setEmail(email);
        setPassword(password);
    }


    public String getEmail() {
        return email;
    }

    // vasya.pupkin@gmail.com.net
    // vasya.pupkin@gmail.net.de
    // vasya.pupkin@gmail.de
    // vasya.pupkin@gmail.com


    /*
    1. @ присутствует и только одна (done)
    2. точка после собаки (done)
    3. после последней точки 2 или больше символов
    4. английский алфавит, цифры, '_', '-', '.', '@'
    5. до собаки должен быть мин 1 символ
     */
    public void setEmail(String email) {
        if (isEmailValid(email)) {
            this.email = email;
        }
    }

    private boolean isEmailValid(String email) {

        // eee@fdff@fdf.com

        // 1. @ присутствует и только одна (done)
        int indexAt = email.indexOf('@');
        if (indexAt == -1 || indexAt != email.lastIndexOf('@')) return false;

        // 2. точка после собаки
        if (email.indexOf('.', indexAt) == -1) return false;

        // 3. после последней точки 2 или больше символов
        // индекс последнего length - 1;
        // индекс пред-последнего  length - 2;

        if (email.lastIndexOf('.') >= email.length() - 2) return false;

        // английский алфавит, цифры, '_', '-', '.', '@'
        for (int i = 0; i < email.length(); i++) {
            char c = email.charAt(i);


            if (!(isContainLegalSymbols(c))) {
                return false;
            }

        }

        return true;
    }

    private boolean isContainLegalSymbols(char c){
        return (Character.isAlphabetic(c) || Character.isDigit(c) || c == '.'
                || c == '_' || c == '-' || c == '@' );
    }

    public String getPassword() {
        return password;
    }

    /*
    Требования к валидному password
    1. длина >= 8
    2. мин 1 цифра
    3. мин 1 маленькая буква
    4. мин 1 большая буква
    5. мин 1 спец.символ ("!%$@&")
     */

 // qR3%    ;

    private boolean isPasswordValid(String password) {
        if (password.length() < 8) return false;
        if (password.equals(this.password)) return false;


        boolean[] res = new boolean[4]; // [false, false, false, false]
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (Character.isDigit(c)) {
                res[0] = true;
            }

            if (Character.isLowerCase(c)) {
                res[1] = true;
            }

            if (Character.isUpperCase(c)) {
                res[2] = true;
            }

            if ("!%$@&".indexOf(c) >= 0) {
                res[3] = true;
            }
        }

//        System.out.println(Arrays.toString(res));
        return res[0] && res[1] && res[2] && res[3];
    }

    public boolean setPassword(String password) {
        if (isPasswordValid(password)) {
            this.password = password;
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Person{" +
                "email='" + email + '\'' +
                '}';
    }
}
