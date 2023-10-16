package lesson_29.flyable;
/*
@date 16.10.2023
@author Sergey Bugaienko
*/

public class Flyer {
    public static void main(String[] args) {
        Airplane airplane = new Airplane(15);
        Flyable duck = new Duck();

        Flyable[] flyables = new Flyable[2];
        flyables[0] = airplane;
        flyables[1] = duck;


        for (Flyable flyer: flyables) {
            flyer.fly();
            if (flyer instanceof Airplane) {
                Airplane test = (Airplane) flyer;
                System.out.println("Количество пассажиров в самолете: " + test.countPassengers());
            }
        }

//        airplane.takePassengers();
//        airplane.countPassengers();
    }
}
