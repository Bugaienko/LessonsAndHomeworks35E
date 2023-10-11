package lesson_25.homework24;
/*
@date 09.10.2023
@author Sergey Bugaienko
*/

public class Bus extends Vehicle {

    int capacity;
    int countPassengers;

    public Bus() {
       this.setModel("Bus-01");
    }

    public Bus(String model, int yearOfMan, int capacity) {
        super(model, yearOfMan); // вызываем конструктор родительского класса
        System.out.println("Конструктор Bus");

//        this.model = model;
//        this.yearOfManufacture = yearOfMan;

        this.capacity = capacity;
    }

    public void takePassenger() {
        if (countPassengers < capacity ) {
            countPassengers++;
            System.out.println("Пассажир зашел в автобус " + this.getModel());
        } else {
            System.out.println("Автобус полный!");
        }
    }

    public void dropOffPassenger(){
        if (countPassengers > 0) {
            countPassengers--;
            System.out.println("Пассажир вышел из автобуса");
        } else {
            System.out.println("В автобусе больше нет пассажиров!");
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCountPassengers() {
        return countPassengers;
    }
}
