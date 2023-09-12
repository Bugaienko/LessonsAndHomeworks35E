package homework_05;
/*
@date 12.09.2023
@author Sergey Bugaienko
*/

/*
Даны строки разной длины (длина - четное число)

"string"
"code"
"Practice"
Необходимо распечатать два средних символа строки. Например, если дана строка "string" - результат будет "ri", для строки "code" результат "od",
для "Practice" результат "ct".
 */
public class Task_03 {
    public static void main(String[] args) {

        //Мультикурсор "Shift + Alt + левый клик"

        //            012345
        String str = "string";
        String str1 = "code";
        String str2 = "Practice";

        int middleIndex = str.length() / 2;
        String subStr = str.substring(middleIndex - 1, middleIndex + 1);
        System.out.println(subStr);

        //             0123456
        String test = "ABCDEFG";
        String sub1 = test.substring(1, 4); // 1, 2, 3 символы взяты в подстроку

        System.out.println(sub1);

        int intVar = 102;

        String strFromNumber =  String.valueOf(intVar);
        String test1 = "100";
        test1 = "" + intVar;
        System.out.println(test1.charAt(1));
        System.out.println(strFromNumber);

        System.out.println("====================");
        String temp = "Java is a powerful language. This is great news";
        String strForSearch = "is";

        // возвращает индекс первого вхождения подстроки в строку. Если не входит - получим -1
        int indexOfIs = temp.indexOf(strForSearch); //
        System.out.println("Индекс первого вхождения: " + indexOfIs);

        System.out.println(temp.lastIndexOf(strForSearch));

        System.out.println(temp.isEmpty()); // проверяет является ли строка пустой
        System.out.println("".isEmpty());

        String strTrim = "    Assasa sdwer!   X  ";
        System.out.println(strTrim.trim() + "|"); //обрезает пробелы в начале и в конце строки, если они есть
        strTrim = strTrim.trim();
        System.out.println(strTrim);

    }
}
