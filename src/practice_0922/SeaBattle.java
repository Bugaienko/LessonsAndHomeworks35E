package practice_0922;
/*
@date 22.09.2023
@author Sergey Bugaienko
*/

import java.util.Random;
import java.util.Scanner;

/*
0 - пустая клетка
1 - был выстрел
8 - корабль
5 - попадание в кораблик

 */
public class SeaBattle {
    public static void main(String[] args) {
        //TOD разнести последовательность выполнения задач по методам
        startGame();

    }

    public static void startGame() {
        int size = 5;
        int sizeBoat = 2;
        int boatsAmount = 1;
//        int[] boatCoordinate = new int[2];

        int countAttempts = 0;
        int goodShots = 0;

        int[][] field = new int[size + 1][size + 1];

        /*
        Проверка правильности задания границ генератора координат
        Random random = new Random();
        int testCounter = 0;
        for (int i = 0; i < 10000; i++) {
            int xCoordinate = random.nextInt((field.length - sizeBoat )) + 1;
            if (xCoordinate ==  4) {
             testCounter++;
            }
        }
        System.out.println("\nконец проверки. " + testCounter);

         */

        readyToStart(size, sizeBoat, boatsAmount);
        int[] boatCoordinate = setBoats(field, sizeBoat);
        showField(field);

        while (goodShots < sizeBoat) {

            int xCoordinate;
            int yCoordinate;

            // Получаем координаты клетки от игрока


            xCoordinate = getCoordinateFromPlayer("вертикали", size, field, boatCoordinate);
//            System.out.println("Получено значение " + xCoordinate);
            yCoordinate = getCoordinateFromPlayer("горизонтали", size, field, boatCoordinate);

            boolean isGoodMove = makeMove(field, xCoordinate, yCoordinate);

            if (isGoodMove) goodShots++;

            showField(field);


            countAttempts++;

            //TOD выход из цикла для тестирования
            // goodShots = sizeBoat;
        } // end while

        System.out.println("Вы нашли все корабли! Поздравляю");
        System.out.println("Кол-во ходов: " + countAttempts);

    }

    private static boolean makeMove(int[][] field, int x, int y) {
        if (field[x][y] == 8) {
            field[x][y] = 5;
            return true;
        } else if (field[x][y] == 0) { //
            //Tod проблема с повторным попаданием (добавить проверку на значение 5)
            field[x][y] = 1;
        }
        return false;
    }

    private static int getCoordinateFromPlayer(String str, int size, int[][] field, int[] helpArray) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Введите координату по %s (число от 1 до %d)\n", str, size);
        int coordinate = 0;

        if (scanner.hasNextInt()) {
            coordinate = scanner.nextInt();
        }

        //TODO если получили 911 - вызвать метод-помогатель! (подумать над неймингом)
        if (coordinate == 911) provideHelp(field, helpArray);
//        System.out.println("Введено: " + coordinate);

        coordinate = (coordinate > 0 && coordinate <= size) ? coordinate : getCoordinateFromPlayer(str, size, field, helpArray);


        return coordinate;
    }

    private static void provideHelp(int[][] field, int[] boatCoordinateArray) {
        // Вар1 Зачеркнуть несколько пустых клеток
        // Вар2 дать одну из координат (горизонт или верт), где есть корабли
//        System.out.println("Что-то полезное происходит!");
        System.out.printf("На строке %s точно-точно есть башня корабля!\n", boatCoordinateArray[0]);
    }

    private static void showField(int[][] field) {
        // TOD Нарисовать поле
        System.out.println();
        for (int i = 0; i < field.length; i++) {

            if (i == 0) {
                //Выводим шапку поля
//                String result = "";
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < field.length; j++) {
//                    result += " " + j + " |";
                    sb.append(" ").append(j).append(" |");
                }
//                System.out.println(result);
                System.out.println(sb.toString());
            } else {
                //Распечатываем строку поля
                StringBuilder res = new StringBuilder(" ").append(i).append(" |");
                for (int j = 1; j < field.length; j++) {
                    res.append(" ").append(getSymbolByIntValue(field[i][j])).append(" |");
                }
                System.out.println(res);
            }
        }
    }

    private static char getSymbolByIntValue(int i) {
        switch (i) {
            case 0:
                return '-';
            case 1:
                return '*';
            case 5:
                return 'X';
            case 8:
                return 'O';
            default:
                return '-';
        }
    }

    private static int[] setBoats(int[][] field, int sizeBoat) {


        Random random = new Random();

        // кораблик стоит в пределах поля

        boolean isVertical = random.nextBoolean(); // генерирует true || false

        int xCoordinate, yCoordinate;

        if (isVertical) {
            // 6 (1..5) -> [0..4] -> [1..5] // если двухпалубный кораблик, то 2 ->
            xCoordinate = random.nextInt((field.length - sizeBoat)) + 1;
            yCoordinate = random.nextInt(field.length - 1) + 1;
            for (int i = xCoordinate; i < xCoordinate + sizeBoat; i++) {
                field[i][yCoordinate] = 8;
            }
            System.out.println(xCoordinate + " : " + yCoordinate);

        } else {
            xCoordinate = random.nextInt(field.length - 1) + 1;
            yCoordinate = random.nextInt(field.length - sizeBoat) + 1;
            for (int i = yCoordinate; i < yCoordinate + sizeBoat; i++) {
                field[xCoordinate][i] = 8;
            }
            System.out.println(xCoordinate + " : " + yCoordinate);
        }
        return new int[]{xCoordinate, yCoordinate};
    }

    private static void readyToStart(int size, int sizeBoat, int boatsAmount) {
        // Выводит правила игры
        // printf -> целое число %d; строку %s, число с запятой %f
        System.out.printf("Игра морской бой ведется на квадратном поле %dx%d\n", size, size);
//        System.out.println("Игра морской бой ведется на квадратном поле " + size + "x" + size + "\n");
        System.out.printf("Количество кораблей на поле: %d\n", boatsAmount);
//        System.out.println("Количество кораблей на поле: " + boatsAmount);
        System.out.println("Игрок вводит координаты поля");
        System.out.println("Программа отображает историю ходов и их результативность на игровом поле");
        System.out.println("Игра заканчивается, когда все корабли найдены");
        System.out.println("Удачи!");
        System.out.println("Для получения подсказки - введите 911 при вводе координат");
        System.out.println("=========================================================");
        System.out.println();

    }
}
