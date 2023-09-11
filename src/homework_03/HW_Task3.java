package homework_03;
/*
@date 11.09.2023
@author Sergey Bugaienko
*/

/*
Задача 3. Найдите в Интернете данные по температуре в вашем городе за прошедшую неделю.
Вычислите среднюю температуру за неделю и выведете ее на печать.
 */
public class HW_Task3 {
    public static void main(String[] args) {

        // Ctrl + Alt + L - авто-форматирование кода

        int temp1 = 28;
        int temp2 = 27;
        int temp3 = 25;
        int temp4 = 27;
        int temp5 = 29;
        int temp6 = 25;
        int temp7 = 23;

        int countValues = 7;

        double averageTemp;
        averageTemp = ((double)temp1 + temp2 + temp3 + temp4 + temp5 + temp6 + temp7) / countValues;

        System.out.printf("Среднее значение температуры за неделю: %.2f\n", averageTemp);

        int a = 5;
        int b = 7;

        System.out.println("Сумма a & b = " + a + b);

        // меняем очередность выполнения операций. Сначала будет выполнено то, что в скобках (сложение двух интов)
        // затем будет конкатенация строки и инта, приведенного к типу String
        System.out.println("Сумма a & b = " + (a + b));
        System.out.println("Сумма a & b = " + (12));






    }
}
