package lesson_03;

public class MathOperations {
    public static void main(String[] args) {
        int a = 20;
        int b = 7;

        //          20 + 7
        int result = a + b; // сложение  +
        System.out.println("Результат: " + result);

        //  результат вычислений выражения, находящегося справа от знака "="
        // будет вычислен, результат помещен в переменную, имя которой находятся слева от знака "="
        result = a - b; // вычитание -

        //      20 * 7
        result = a * b; // умножение *
        System.out.println("Результат умножения a * b: " + a + " * " + b + " = " + result);

        int test = 10 / 2;
        System.out.println(test);

        //             22 разделить на 7 - 3 + 1 в остатке -> Так НЕ бывает
        int resultDiv = a / b; // целочисленное деление / 2.857...
        System.out.println("Результат деления: " + resultDiv);
        // (10 % 3) -> 3.3333333333333333333333333

        int restDiv3 = 20 % 7;





        // Остаток от деления
        int restDiv = a % b; // остаток от деления %
        System.out.println("остаток от деления: " + restDiv);

        // 20 % 7 = 6;
        // 20 / 7 -> 2 : 20 - (2 * 7) = 20 - 14 = 6;
        // 20 - 7 -> 13 - 7 -> 6

        System.out.println(21 % 7);
        // 21 / 7 -> 3 = 21 - (3 * 7)
        // 21 - 7 = 14 - 7 = 7 - 7 = 0;


        // 5 / 10 ->  0.5 -> 0
        int restDiv2 = 5 % 10;
        System.out.println(restDiv2);

        // 5 разделить на 10 -> 0.5 -> .5 - отброшено. 5 / 10 -> результат = 0
        // 5 % 10 -> 0 целых. 5 - (0 * 10) -> 5
        // 22 / 7 -> 3
        // 22 % 7 -> 15 - 7 -> 8 - 7 -> 1
        // 22 - (3 * 7) = 1 - остаток от деления

        // x % 2 -> 0, 1;
        // x % 3 -> 0, 1, 2
        // x % y -> [0, y-1] включительно
        System.out.println(9 / 2);
        System.out.println((9 % 2));


        // Shift + Alt + стрелки вверх / вниз

        System.out.println();
        System.out.println(" ==================================== ");

        float floatVar;
        floatVar = 20.0f;

        double doubleVar = 20.0d; // число записано в типе double
        double doubleVar2 = 20.0; // все числа, записанные с точкой в Java по умолчанию считаются типом double
        double doubleSeven = 7.0;

        double resultDoubleDiv =  doubleVar / doubleSeven;
        System.out.println(resultDoubleDiv);

        System.out.printf("Результат деления 20 на 7 равен %.2f, но не %.1f\n", resultDoubleDiv, doubleSeven);

//        System.out.println("Строка 1\nСтрока 2\nСтрока 3"); // перевод каретки \n
        System.out.println();
        System.out.println("Приведение типов");

        int intVar1 = 20;
        int intVar2 = 7;

        //                     20.0 / 7.0
        double resultDouble = (double) intVar1 / (double) intVar2;
        System.out.println("Результат после приведения типов " + resultDouble);

        int resultInt = (int) (doubleVar / doubleSeven);
        System.out.println("int from double " + resultInt);

        double varDoub =  20;
        System.out.println(varDoub);

        long longVar = 10L;
        int x = (int) longVar;
        longVar = x;





    }
}
