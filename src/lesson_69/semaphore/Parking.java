package lesson_69.semaphore;
/*
@date 20.12.2023
@author Sergey Bugaienko
*/

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

/*
Создать многопоточное приложение для симуляции работы парковки с учетом различного времени пребывания автомобилей и ведения статистики.

Создайте парковку на 5 мест.
Напишите код для 10 потоков, где каждый поток представляет собой автомобиль, который пытается припарковаться.
Организовать контроль доступа к парковочным местам. При отсутствии свободных мест автомобиль должен ожидать.
Каждый автомобиль должен проводить на парковке случайное количество времени от 3 до 10 секунд.
Программа должна учитывать общее время, проведенное всеми автомобилями на парковке.
По завершении работы всех потоков программа должна рассчитать и вывести среднее время пребывания одного автомобиля на парковке.
В консоль должны выводиться сообщения о приезде автомобиля, его парковке, времени пребывания на парковке и уезде.
 */
public class Parking {
    private static final int PLACES = 5;
    private final static boolean[] PARKING_PLACES = new boolean[PLACES];
    private final static Semaphore SEMAPHORE = new Semaphore(PLACES, true);
    private final static AtomicInteger totalParkingTime = new AtomicInteger();
    private final static int CARS_COUNT = 10;

    /*
    Shutdown hook - это поток, который запускается в ответ на завершение работы JVM. Происходит это в трех случаях:
    1. Программа нормально завершилась (все потоки, включая main успешно завершились);
    2. Программа получает сигнал на прерывание. Например System.exit();
    3. JVM завершает в ответ на пользовательское прерывание, нажатие Ctrl + C;
     */

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Общее время на парковке: " + totalParkingTime.get());
            System.out.println("Среднее время парковки одного авто: " + totalParkingTime.doubleValue() / CARS_COUNT);
        }));
    }

    public static void main(String[] args) {

        for (int i = 0; i < CARS_COUNT; i++) {
            new Thread(new Car(i)).start();
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(300, 601));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    } // main


    public static class Car implements Runnable {
        private final int carId;

        public Car(int carId) {
            this.carId = carId;
        }

        @Override
        public void run() {
            System.out.printf("Автомобиль %d подъехал к парковке\n", carId);
            try {
                // запрашиваем доступ к парковке
                //если доступ запрещен - поток останавливается и ждет, пок5а у светофора появятся разрешения
                SEMAPHORE.acquire();
                System.out.printf("Автомобиль %d заезжает на паркову\n", carId);
                int place = takePlace();
                int sleepTime = ThreadLocalRandom.current().nextInt(3000, 10001);
                System.out.printf("Автомобиль %d припарковался на место %d. Время стоянки: %d \n", carId, place, sleepTime);
                Thread.sleep(sleepTime);

                //добавляем в счетчик общего времени парковки всех авто
                totalParkingTime.addAndGet(sleepTime);

                leavePlace(place);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                SEMAPHORE.release();
            }
        }

        private void leavePlace(int place) {
            synchronized (PARKING_PLACES) {
                PARKING_PLACES[place] = false;
                System.out.printf("Автомобиль %d освобождает место %d\n", carId, place);
            }
        }

        private int takePlace() {
            synchronized (PARKING_PLACES) {
                for (int i = 0; i < PARKING_PLACES.length; i++) {
                    if (!PARKING_PLACES[i]) {
                        PARKING_PLACES[i] = true;
                        System.out.printf("Автомобиль %d занимает место %d\n", carId, i);
                        return i;
                    }
                }
                return -1; // такая ситуация не возможна, тк наличие свободных мест контролирует Семафор
            }
        }
    } // Car

} // Parking