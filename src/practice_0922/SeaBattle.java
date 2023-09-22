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
        //TODO разнести последовательность выполнения задач по методам
        startGame();

    }

    public static void startGame() {
        int size = 5;
        int sizeBoat = 2;

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

        readyToStart();
        setBoats(field, sizeBoat);
        showField(field);

        while (goodShots < sizeBoat) {

            int xCoordinate;
            int yCoordinate;

            // Получаем координаты клетки от игрока


            xCoordinate = getCoordinateFromPlayer("горизонтали", size);
//            System.out.println("Получено значение " + xCoordinate);
            yCoordinate = getCoordinateFromPlayer("вертикали", size);

            boolean isGoodMove = makeMove(field, xCoordinate, yCoordinate);

            if (isGoodMove) goodShots++;

            showField(field);


            countAttempts++;

            //TODO выход из цикла для тестирования
            goodShots = sizeBoat;
        } // end while

        System.out.println("Вы нашли все корабли! Поздравляю");
        System.out.println("Кол-во ходов: " + countAttempts);

    }

    private static boolean makeMove(int[][] field, int x, int y) {
        if (field[x][y] == 8) {
            field[x][y] = 5;
            return true;
        } else {
            //TODO проблема с повторным попаданием (добавить проверку на значение 5)
            field[x][y] = 1;
            return false;
        }
    }

    private static int getCoordinateFromPlayer(String str, int size) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Введите координату по %s (число от 1 до %d)\n", str, size);
        int coordinate = 0;

        if (scanner.hasNextInt()) {
            coordinate = scanner.nextInt();
        }

        System.out.println("Введено: " + coordinate);

        coordinate = (coordinate > 0 && coordinate <= size) ? coordinate : getCoordinateFromPlayer(str, size);


        return coordinate;
    }

    private static void showField(int[][] field) {
        // TODO Нарисовать поле
        System.out.println();
        for (int i = 0; i < field.length; i++) {

            if (i == 0) {
                String result = "";
                for (int j = 0; j < field.length; j++) {
                    result += " " + j +  " |";
                }
                System.out.println(result);
                //TODO шапку
            } else {
                //TODO распечатать строку поля
                String res = " " + i + " |";
                for (int j = 1; j < field.length; j++) {
                    res += " " + getSymbolByIntValue(field[i][j]) + " |";
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

    private static void setBoats(int[][] field, int sizeBoat) {

        Random random = new Random();

        // кораблик стоит в пределах поля

        boolean isHorizontal = random.nextBoolean(); // генерирует true || false

        int xCoordinate, yCoordinate;

        if (isHorizontal) {
            // 6 (1..5) -> [0..4] -> [1..5] // если двухпалубный кораблик, то 2 ->
            xCoordinate = random.nextInt((field.length - sizeBoat)) + 1;
            yCoordinate = random.nextInt(field.length - 1) + 1;
            for (int i = xCoordinate; i < xCoordinate + sizeBoat; i++) {
                field[i][yCoordinate] = 8;
            }

            // 6. 2. -> nextInt(5 - 2 ) + 1 -> [1..5]
        } else {
            xCoordinate = random.nextInt(field.length - 1) + 1;
            yCoordinate = random.nextInt(field.length - sizeBoat) + 1;
            for (int i = yCoordinate; i < yCoordinate + sizeBoat; i++) {
                field[xCoordinate][i] = 8;
            }
        }


    }

    private static void readyToStart() {
        // TODO рассказать правила

    }
}
