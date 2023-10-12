package lesson_27.runners;
/*
@date 12.10.2023
@author Sergey Bugaienko
*/

public class AmateurRunner extends Human{


    public AmateurRunner() {

        setSpeed(15);
        setRestTime(10);

        super.typeRunner = "Amateur";
    }

    public AmateurRunner(int speed, int restTime) {
        super(speed, restTime);
        super.typeRunner = "Amateur";
    }
}
