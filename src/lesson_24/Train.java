package lesson_24;
/*
@date 09.10.2023
@author Sergey Bugaienko
*/

public class Train extends Vehicle {

    int capacity;
    int countPassengers;
    int countWagons;
    static final int WAGON_CAPACITY = 32; // Ctrl + Shift + U

    public Train(String model, int yearOfManufacture, int countWagons) {
        super(model, yearOfManufacture);
        this.countWagons = countWagons;
        this.capacity = countWagons * WAGON_CAPACITY;
    }

    public int getCountWagons() {
        return countWagons;
    }

    public void setCountWagons(int countWagons) {
        capacity = countWagons * WAGON_CAPACITY;
        this.countWagons = countWagons;
    }
}
