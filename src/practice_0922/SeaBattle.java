package practice_0922;
/*
@date 22.09.2023
@author Sergey Bugaienko
*/

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
0 - пустая клетка
1 - был выстрел
2 - соседняя с кораблем клетка
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

        int countAttempts = 0;
        int goodShots = 0;

        int difficultyLevel;


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
        difficultyLevel = selectGameDifficulty();
        System.out.println("Уровень: " + difficultyLevel);

        switch (difficultyLevel) {
            case 1:
                sizeBoat = 3;
                break;
            case 2:
                sizeBoat = 5;
                break;
            case 3:
                sizeBoat = 8;
                break;
            default:
                sizeBoat = 3;
        }

        int[] boatCoordinate = setBoats(field, true, difficultyLevel);

        readyToStart(size, sizeBoat, boatsAmount);
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

        } // end while

        System.out.println("Вы нашли все корабли! Поздравляю");
        System.out.println("Кол-во ходов: " + countAttempts);

    }

    private static int selectGameDifficulty() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите уровень сложности");
        System.out.println("(E)asy/(M)edium/(H)ard:");
        char select = scanner.nextLine().trim().toUpperCase().charAt(0);

        switch (select) {
            case 'M':
                return 2;
            case 'H':
                return 3;
            case 'E':
            default:
                return 1;
        }
    }

    private static boolean makeMove(int[][] field, int x, int y) {
        Random random = new Random();
        if (field[x][y] == 8) {
            System.out.println("Попал!");
            field[x][y] = 5;
            return true;
        } else if (field[x][y] == 0) { //
            //Tod проблема с повторным попаданием (добавить проверку на значение 5)
            field[x][y] = 1;
        } else if (field[x][y] == 2) {
            if (random.nextBoolean()) System.out.println("Ух!.. Близко");
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
                return '\u00b7';
//                return '-';
            case 1:
                return '*';
            case 2:
                return '\u00b7';
//                return '+';
            case 5:
                return 'X';
            case 8:
//                return '\u00b7';
                return 'O';
            default:
                return '\u00b7';        }
    }

    private static int[] setBoats(int[][] field, boolean flag, int difficultyLevel) {

//        System.out.println("setBoats v2: ");

        switch (difficultyLevel) {
            case 3:
                System.out.println("Ставлю 1-палубный корабль");
                System.out.println("Ставлю 2-палубный корабль");
            case 2:
                System.out.println("Ставлю 2-палубный корабль");
            case 1:
            default:
                System.out.println("Ставлю 3-палубный корабль");

        }

        //создаем 1 корабль на 3 клетки
        int sizeBoat = 3;
        int[] coordinateFirstBoat = setBoats(field, sizeBoat);

        if (difficultyLevel == 1) return coordinateFirstBoat;

        marksCellsNearBoat(field, coordinateFirstBoat, sizeBoat);


        //ставим 2-х палубный
        sizeBoat = 2;
        coordinateFirstBoat = setBoats(field, sizeBoat);
        marksCellsNearBoat(field, coordinateFirstBoat, sizeBoat);

        //TODO убрать
        //showField(field);

        if (difficultyLevel == 3) {
            //ставим еще 2-х палубный
            coordinateFirstBoat = setBoats(field, 2);
            marksCellsNearBoat(field, coordinateFirstBoat, sizeBoat);

            //TODO убрать
            //showField(field);

            //ставим однопалубный
            sizeBoat = 1;
            coordinateFirstBoat = setBoats(field, sizeBoat);
            if (coordinateFirstBoat[0] < 0) {
//                System.err.println("Перерисовываем корабли заново!");
                //очистить field
                clearField(field);
                return setBoats(field, flag, difficultyLevel);
            }
            marksCellsNearBoat(field, coordinateFirstBoat, sizeBoat);
        }


        return coordinateFirstBoat;
    }

    private static void clearField(int[][] field) {
        // System.out.println("Очищаем игровое поле");
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = 0;
            }
        }
    }

    private static int[] setBoats(int[][] field, int sizeBoat) {
//        System.out.println("Сет боат 1");


        Random random = new Random();

        // кораблик стоит в пределах поля


        boolean isVertical = random.nextBoolean(); // генерирует true || false

        int xCoordinate = 0, yCoordinate = 0;

        int[] xy = getRandomCoordinateX(field, sizeBoat, isVertical);
        xCoordinate = xy[0];
        yCoordinate = xy[1];
        // (isVertical) ? 0 : 1
        if (xy[2] == 0) {

//            System.out.println("Вертикаль. Получены координаты: " + Arrays.toString(xy));
            if (xy[0] > 0) {
                xCoordinate = xy[0];
                yCoordinate = xy[1];
//            System.out.println("отмечаем корабль: " + xCoordinate + " : " + yCoordinate + " s" + sizeBoat + " " + (xy[2] == 0));

                for (int i = xCoordinate; i < xCoordinate + sizeBoat; i++) {
                    field[i][yCoordinate] = 8;
                }
            }

//            System.out.println(xCoordinate + " : " + yCoordinate);

        } else {

            if (xy[0] > 0) {
                xCoordinate = xy[0];
                yCoordinate = xy[1];
//            System.out.println("Ставлю: " + xCoordinate + " : " + yCoordinate);

                for (int i = yCoordinate; i < yCoordinate + sizeBoat; i++) {
                    field[xCoordinate][i] = 8;
                }
            }
        }
        return new int[]{xCoordinate, yCoordinate, xy[2]};
    }

    private static int[] getRandomCoordinateX(int[][] field, int sizeBoat, boolean isVertical) {
//        System.out.println("Запуск генерации координат размер: " + sizeBoat + " isVertical: " + isVertical);
        Random random = new Random();


        int x = 0, y;
        if (isVertical) {
            x = random.nextInt((field.length - sizeBoat)) + 1;
            y = random.nextInt(field.length - 1) + 1;

            boolean isCoordinateGood = checkCoordinate(field, x, y, sizeBoat, isVertical);
            if (isCoordinateGood) {
//                System.out.println("Могу поставить корабль вертикально: " + x + ":" + y);
                return new int[]{x, y, (isVertical) ? 0 : 1};
                //TODO
            } else {
//                System.out.println("Не могу поставить корабль вертикально: " + x + ":" + y + " S:" + sizeBoat);
                // TODO
            }

            int idx = 0;
            int maxLen = 0;
            {
//                System.out.println("Проверка координаты");


                for (int i = 1; i < field.length; i++) {

                    int maxBoatSizeInX = 0;
                    if (field[x][i] == 0) {
                        maxBoatSizeInX++;

                        A:
                        for (int j = x + 1; j < field.length; j++) {
                            if (field[j][i] == 0) {
                                maxBoatSizeInX++;
                            } else {
                                break A;
                            }
                        }
                    }
//                    TODO System.out.printf("%d:%d макс подряд (башня) %d\n", x, i, maxBoatSizeInX);

                    if (maxBoatSizeInX > maxLen) {
                        maxLen = maxBoatSizeInX;
                        idx = i;
                    }

                }
                // TODO System.out.printf("Макс возможный %d от индекса %d\n", maxLen, idx);
            }

            if (maxLen < sizeBoat) {
                // не могу поставить в эту Х корабль такой длинны
                //TODO проверить. Регенерация
                boolean isFreeCellsFor = checkFreeSpace(field, sizeBoat);

                if (isFreeCellsFor) {
                    return getRandomCoordinateX(field, sizeBoat, random.nextBoolean());
                } else {
                    //TODO больше нет места. Надо что-то делать (менять размер поля или другую расстановку с начала
                    return new int[]{-2, -2, 0};
                }
            } else {
                x = x + random.nextInt(maxLen - sizeBoat + 1);
//                System.out.println(x + " : " + idx);
                return new int[]{x, idx, (isVertical) ? 0 : 1};
            }

        } else {
            //TODO для корабля башни

            x = random.nextInt((field.length - 1)) + 1;
            y = random.nextInt(field.length - sizeBoat) + 1;

            boolean isCoordinateGood = checkCoordinate(field, x, y, sizeBoat, isVertical);
            if (isCoordinateGood) {
//                System.out.println("Могу поставить корабль горизонтально " + x + " : " + y);
                return new int[]{x, y, (isVertical) ? 0 : 1};
                //TODO
            } else {
//                System.out.println("Не могу поставить корабль горизонтально: " + x + ":" + y + " S:" + sizeBoat);
                // TODO
            }


            int idx = 0;
            int maxLen = 0;
            {
//                System.out.println("Проверка координаты");
                // Получилась проверка поставить кораблик-бревно
                //TODO
                //проверка одной линии


                for (int i = 1; i < field.length; i++) {
                    int maxBoatSizeInX = 0;
                    if (field[x][i] == 0) {
                        maxBoatSizeInX++;
                        A:
                        for (int j = i + 1; j < field.length; j++) {
                            if (field[x][j] == 0) {
                                maxBoatSizeInX++;
                            } else {
                                break A;
                            }
                        }
                    }
//                    System.out.printf("%d:%d макс подряд (бревно) %d\n", x, i, maxBoatSizeInX);

                    if (maxBoatSizeInX > maxLen) {
                        maxLen = maxBoatSizeInX;
                        idx = i;
                    }

                }
//                System.out.printf("Макс возможный %d от индекса %d\n", maxLen, idx);
            }

            if (maxLen < sizeBoat) {
                // не могу поставить в эту Х корабль такой длинны

                boolean isFreeSpace = checkFreeSpace(field, sizeBoat);
                if (isFreeSpace) {
                    return getRandomCoordinateX(field, sizeBoat, random.nextBoolean());
                } else {
                    //TODO надо перерисовывать поле
                    //TODO больше нет места. Надо что-то делать (менять размер поля или другую расстановку с начала
                    return new int[]{-2, -2, 0};
                }

            } else {
                int newY = idx + random.nextInt(maxLen - sizeBoat + 1);
//                System.out.println("Y: " + newY);
                return new int[]{x, newY, (isVertical) ? 0 : 1};
            }

        }

    }

    private static boolean checkFreeSpace(int[][] field, int sizeBoat) {
        for (int i = 1; i < field.length; i++) {
            for (int j = 1; j < field.length; j++) {

                boolean isFree = checkCoordinate(field, i, j, sizeBoat, true);
                if (isFree) {
//                    System.out.println("Еще есть место");
                    return true;
                }
                isFree = checkCoordinate(field, i, j, sizeBoat, false);
                if (isFree) {
//                    System.out.println("Еще есть место");
                    return true;
                }


            }
        }
//        System.err.println("Для корабля нет места! s:" + sizeBoat);
        return false;
    }

    private static boolean checkCoordinate(int[][] field, int x, int y, int sizeBoat, boolean isVertical) {
        if (x < 1 || y < 1) return false;

        if (isVertical) {
            if (x + sizeBoat > field.length - 1) return false;
            for (int i = x; i < x + sizeBoat; i++) {
                if (field[i][y] != 0) return false;
            }
            return true;
        } else {
            if (y + sizeBoat > field.length - 1) return false;
            for (int i = y; i < y + sizeBoat; i++) {
                if (field[x][i] != 0) return false;
            }
            return true;
        }
    }


    private static boolean checkVerticalCoordinate(int[][] field, int x, int y, int sizeBoat) {
        if (x < 1 || y < 1) return false;
        for (int i = x; i < x + sizeBoat; i++) {
            if (field[i][y] != 0) return false;
        }
        return true;
    }

    private static boolean checkVerticalHorizontal(int[][] field, int x, int y, int sizeBoat) {
        if (x < 1 || y < 1) return false;
        for (int i = y; i < y + sizeBoat; i++) {
            if (field[x][i] != 0) return false;
        }
        return true;
    }


    private static void marksCellsNearBoat(int[][] field, int[] coordinateFirstBoat, int sizeBoat) {
//        System.out.println("Будем рисовать size: " + sizeBoat);
        int xMin, xMax, yMin, yMax;


        // if direction
        if (coordinateFirstBoat[2] == 0) {
            // корабль башенка
            xMin = coordinateFirstBoat[0] - 1;
            xMax = coordinateFirstBoat[0] + sizeBoat;
            yMin = coordinateFirstBoat[1] - 1;
            yMax = coordinateFirstBoat[1] + 1;
        } else {
            xMin = coordinateFirstBoat[0] - 1;
            xMax = coordinateFirstBoat[0] + 1;
            yMin = coordinateFirstBoat[1] - 1;
            yMax = coordinateFirstBoat[1] + sizeBoat;
        }

//        System.out.printf("min(%d,%d) ->  max(%d,%d)\n", xMin, yMin, xMax, yMax);


        for (int x1 = Math.max(xMin, 1); x1 <= Math.min(xMax, field.length - 1); x1++) {
            for (int y1 = Math.max(yMin, 1); y1 <= Math.min(yMax, field.length - 1); y1++) {
                if (field[x1][y1] != 8) {
                    field[x1][y1] = 2;
                }
            }
        }

        //показываю поле после разметки
        // showField(field);
    }


    private static void readyToStart(int size, int sizeBoat, int boatsAmount) {
        // Выводит правила игры
        // printf -> целое число %d; строку %s, число с запятой %f
        System.out.printf("Игра морской бой ведется на квадратном поле %dx%d\n", size, size);
//        System.out.println("Игра морской бой ведется на квадратном поле " + size + "x" + size + "\n");
//        System.out.printf("Количество кораблей на поле: %d\n", boatsAmount);
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
