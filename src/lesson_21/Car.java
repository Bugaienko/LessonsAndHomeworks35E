package lesson_21;
/*
@date 04.10.2023
@author Sergey Bugaienko
*/

public class Car {

    static int countCar;
    private final String model;
    private int powerPS;


    public Car(String model, int powerPS) {
        this.model = model;
        this.powerPS = powerPS;
        countCar++;
    }

    public void info() {
        System.out.println("Саr " + model + "; power: " + powerPS + ". Всего выпущено машин: " + countCar );
        getCountCar();
    }

    public static int getCountCar() {
      //  info(); -  не может вызвать
        // model = "Sre"; не может обратиться
        // powerPS = 100; не может обратиться
        return countCar;
    }

    public static void main(String[] args) {
        Car car1 = new Car("BMW", 200);

        Car car2 = new Car("Skoda", 150);
        car1.info();

        System.out.println("Всего создано автомобилей: " + Car.countCar);
        System.out.println("Всего создано автомобилей: " + Car.getCountCar());


    }



}
