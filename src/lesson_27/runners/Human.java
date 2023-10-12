package lesson_27.runners;
/*
@date 12.10.2023
@author Sergey Bugaienko
*/

// public final class Human { -> Если класс помечен ключевым словом final - от него нельзя наследоваться
public class Human {
    private int speed;
    private int restTime;
    // TODO можно ли унаследовать файнал поле?
    protected String typeRunner;

    public Human() {
        this.speed = 10;
        this.restTime = 15;
        typeRunner = "Usual human";
    }

    public Human(int speed, int restTime) {
        this.speed = speed;
        this.restTime = restTime;
        typeRunner = "Human";
    }

    public void run() {
        System.out.println(typeRunner + " бежит со скоростью " + speed);
        rest(restTime);
    }

    public void rest(int time) {
        System.out.println("Мне нужен отдых: " + time);
    }

    // final метод нельзя переопределить в наследниках
    public final void sayHello() {
        System.out.println("Hello");
    }



    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getRestTime() {
        return restTime;
    }

    public void setRestTime(int restTime) {
        this.restTime = restTime;
    }
}
