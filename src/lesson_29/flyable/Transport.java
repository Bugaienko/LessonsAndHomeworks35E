package lesson_29.flyable;
/*
@date 16.10.2023
@author Sergey Bugaienko
*/

public abstract class Transport {
    int capacity;

    public Transport(int capacity) {
        this.capacity = capacity;
    }

    abstract void takePassengers();
    public int countPassengers() {
        return capacity;
    }
}
