package lesson_27.runners;
/*
@date 12.10.2023
@author Sergey Bugaienko
*/

public class ProRunner extends Human{


    public ProRunner() {
        setSpeed(25);
        setRestTime(5);
        super.typeRunner = "Pro runner";
    }

    public ProRunner(int speed, int restTime) {
        super(speed, restTime);
        super.typeRunner = "Pro runner";
    }
}
