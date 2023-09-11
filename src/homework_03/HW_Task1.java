package homework_03;
/*
@date 11.09.2023
@author Sergey Bugaienko
*/

public class HW_Task1 {

    /*
    Задача 1. Объявите 10 переменных типа int со значениями 0,1, 2, 3, 4, 5, 6, 7, 8, 9.
    Объявите ещё одну переменную int и сохраните в неё сумму этих переменных, деленную на 10.
    Получается, у вас будет среднее арифметическое этих чисел в одной переменной.
    Распечатайте её через println. Сколько программа отбросила в дробной части?
     */

    public static void main(String[] args) {
        int var0 = 0;
        int var1 = 1;
        int var2 = 2;
        int var3 = 3;
        int var4 = 4;
        int var5 = 5;
        int var6 = 6;
        int var7 = 7;
        int var8 = 8;
        int var9 = 9;

        // количество переменных будем хранить в переменной
        int countVariables = 10;


        // сумма всех чисел
        int sum = (var0 + var1 + var2 + var3 + var4 + var5 + var6 + var7 + var8 + var9);
        System.out.println("Сумма: " + sum);

        // среднее арифметическое - сумма деленная на кол-во чисел
        int averageValue = sum / countVariables;
        System.out.println("Среднее арифметическое: " + averageValue);

        // вычисляем двумя способами отброшенную дробную часть
        System.out.println("Отброшено в дробной части: " + ((double)sum / countVariables - averageValue));
        System.out.println("Отброшено в дробной части: " + ((double)sum % countVariables / countVariables));

    }
}
