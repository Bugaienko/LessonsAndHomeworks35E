package homework_03;
/*
@date 11.09.2023
@author Sergey Bugaienko
*/

/*
Задача 5(*). int x = 3
Чему будет равно значение х после выполнения операции x += x++ ?
Проверьте свое предположение на практике.
 */
public class HW_Task5_PlusIncrement {
    public static void main(String[] args) {

        int x = 3; // объявлена переменная x, потом инициализированная значение 3
//        x++; // x = x + 1;

        // присвоение нового значения / изменение значения переменной
//       x = x + 1; // вычислен результат выражения в правой части. Затем присвоен в переменную, указанную в левой части


        // String temp = "х стока 18 -> " + x++; // что происходит в методе println
        System.out.println("х стока 18 -> " + ++x + ++x + ++x);
        System.out.println("Текущее значение: " + x);

//        x--; // x = x - 1;
        System.out.println("х стока 21 -> " + --x);

        System.out.println(10 + x--);
        System.out.println(x);
        System.out.println("+++++++++++++++++++++++++");

        int y = 10;


        y += 5; // y = y + 5;
        System.out.println(y);

        y -= 10; // y = y - 10;
        System.out.println(y);

//        y *= 2;
//        y /= 3;
        y %= 5; // y = y % 5;
        System.out.println(y);

        String str = "str";
        str += " fff";
        System.out.println(str);


    }
}
