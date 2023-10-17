package lesson_30.generics;
/*
@date 17.10.2023
@author Sergey Bugaienko
*/

public class Wrappers {
    /*
    Byte -> byte
    Short ->
    Integer -> int
    Long ->
    Float ->
    Double ->
    Character -> char
    Boolean -> boolean
     */

    public static void main(String[] args) {
        Integer x = 5; // авто-упаковка
        System.out.println(x);
        int intValue = x; // авто-распаковка
        System.out.println(intValue);

        Double d = 15.0;
        System.out.println(d);
        System.out.println(d.doubleValue()); // принудительное преобразование в примитивный тип данных

        int x1 = Integer.valueOf("12");
        System.out.println(x1 + 5);
        Double.valueOf("15.5");

        Integer test = Integer.parseInt("12");
        System.out.println(test + 10);

        double testD = Double.parseDouble("12.5");
        System.out.println(testD + 4);



        // -128.. 127 -> происходит кеширование объектов
        Integer a = 127;
        Integer b = 127;
        System.out.println(a == b);

        Integer c = 128;
        Integer e = 128;
        System.out.println("128 == " + (c == e)); // распаковки не происходит. Сравниваются ссылки
        System.out.println("128 == " + (c + 1 == e + 1)); // распаковка происходит. Производится мат.операции, сравниваются значения вычислений
        System.out.println("128 == " + (c.intValue() == e.intValue())); // принудительная распаковка. Сравниваются значения
        System.out.println("equals: " + c.equals(e)); // рекомендуемый метод сравнения по значениям

        String str1 = "Hello";
        String str2 = "Hello";
        System.out.println("str == " + (str1 == str2));


        // Number родительский абстрактный класс для всех числовых классов-оберток
        /*
        7 методов: xxxValue(); -> кастировать в соответсвующий примитивный тип данных
        intValue()
        floatValue()
         */

        Double testCastD = 106.54;
        int value = testCastD.intValue();
        float fValue = testCastD.floatValue();
        System.out.println(fValue);
        System.out.println(value);


    }
}
