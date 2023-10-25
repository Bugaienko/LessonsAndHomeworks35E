package lesson_36.cars;
/*
@date 25.10.2023
@author Sergey Bugaienko
*/

import java.util.Arrays;
import java.util.Comparator;

public class CarsApp {
    public static void main(String[] args) {
        Car[] cars = new Car[5];
        cars[0] = new Car("Alfa", 2021, 120);
        cars[1] = new Car("BMW", 2000, 190);
        cars[2] = new Car("Citroen", 2018, 190);
        cars[3] = new Car("Dodge", 2023, 205);
        cars[4] = new Car("Ferrari", 2021, 300);

        System.out.println(Arrays.toString(cars));

        int[] ints = new int[]{9, 5, 1, 2, 4, 3, 0};
        System.out.println(Arrays.toString(ints));
        Arrays.sort(ints);
        System.out.println(Arrays.toString(ints));

        Arrays.sort(cars);
        System.out.println(Arrays.toString(cars));
        // a == b; Сравнение на равенство двух примитивов
        // str1.equals(str2) - сравнение на равенство двух ссылочных типов

        CarYearComparator carYearComparator = new CarYearComparator();
        CarSpeedComparator carSpeedComparator = new CarSpeedComparator();

        Arrays.sort(cars, carYearComparator);
        System.out.println(Arrays.toString(cars));

        Arrays.sort(cars, carSpeedComparator);
        System.out.println(Arrays.toString(cars));

        Arrays.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car car1, Car car2) {
                return car1.getModel().compareTo(car2.getModel());
            }
        });

        System.out.println(Arrays.toString(cars));

        Arrays.sort(cars, (car1, car2) -> car1.getModel().compareTo(car2.getModel()));
        //Arrays.sort(cars, Comparator.comparing(Car::getModel));


        Arrays.sort(cars, (car1, car2) -> car2.getYear() - car1.getYear());
        System.out.println(Arrays.toString(cars));

        Arrays.sort(cars, (car1, car2) -> {
//            int yearCompare = car1.getYear() - car2.getYear();
            int yearCompare = Integer.compare(car1.getYear(), car2.getYear());
            if (yearCompare == 0) {
                return car2.getModel().compareTo(car1.getModel());
            } else {
                return yearCompare;
            }
        });
        System.out.println(Arrays.toString(cars));

        Comparator<Car> yearComparator = (c1, c2) -> Integer.compare(c1.getYear(), c2.getYear());
        Arrays.sort(cars, yearComparator);


        Comparator<Car> speedYearComparator = Comparator
                .comparing(Car::getMaxSpeed)
                .reversed().thenComparing(Car::getYear);

        Arrays.sort(cars, speedYearComparator);
        System.out.println(Arrays.toString(cars));


        Comparator<Car> comparator = Comparator.comparing(Car::getYear).reversed()
                .thenComparing(Car::getMaxSpeed).reversed();

        comparator = Comparator.comparing(Car::getYear)
                .thenComparing(Comparator.comparing(Car::getMaxSpeed).reversed());
        Arrays.sort(cars, comparator);
        System.out.println(Arrays.toString(cars));

    }

    // Реализовать сортировку по максимальной скорости по обуванию
    // если скорости равны - отсортировать по возрастанию года

    // Реализовать сортировку Car по году выпуска,
    // если год совпадает - сортировать в порядке убывания макс.скорости






}
