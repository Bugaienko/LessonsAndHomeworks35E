package homework_10;
/*
@date 19.09.2023
@author Sergey Bugaienko
*/

/*
Task 0 Распечатать 10 строк: “Task1”. “Task2”. … “Task10”. Используем цикл while
 */
public class Task_00 {
    public static void main(String[] args) {

        int f = 1;
        while (f <= 10) {
            System.out.println("Task" + f + "." );
            f++;
        }

    }
}
