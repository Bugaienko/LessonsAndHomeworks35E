package lesson_36.cars;
/*
@date 25.10.2023
@author Sergey Bugaienko
*/

import java.util.Comparator;

public class CarSpeedComparator implements Comparator<Car> {

    @Override
    public int compare(Car car1, Car car2) {
        return car1.getMaxSpeed() - car2.getMaxSpeed();
    }
}
