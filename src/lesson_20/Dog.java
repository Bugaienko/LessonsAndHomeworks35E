package lesson_20;
/*
@date 02.10.2023
@author Sergey Bugaienko
*/

/*
Написать класс Собака.
Собака должна иметь имя и высоту прыжка
Должна уметь прыгать и должна уметь тренироваться.
За каждую тренировку высота прыжка увеличивается на 10 сантиметров
Максимальная высота, которую может натренировать собака не может быть больше, чем 2 раза высоту первоначального прыжка.

Также должен быть метод взять барьер.
В параметрах метод принимает высоту прыжка.
Если собака в состоянии преодолеть этот барьер - прыгает.
Если не в состоянии, нужно проверить
помогут ли тренировки (будет ли данная собака в принципе в состоянии взять барьер).

Если да -> идем тренироваться -> берет барьер

 */
public class Dog {
    private String name;
    private int jumpHeight;

    private int increasePerOneTraining;
    private int maxJumpHeight;

    public Dog(String name, int jumpHeight) {
        this.name = name;
        this.jumpHeight = jumpHeight;
        this.increasePerOneTraining = 10;
        this.maxJumpHeight = jumpHeight * 2;
    }

    public void jump() {
        System.out.println(name + " прыгнула!");
    }

    public void train() {

        if (jumpHeight < maxJumpHeight) {
            jumpHeight += increasePerOneTraining;
        }

        if (jumpHeight > maxJumpHeight) {
            jumpHeight = maxJumpHeight;
        }

    }

    public boolean takeBarrier(int barrier) {
        // Текущий прыжок vs барьер?
        if (jumpHeight >= barrier) {
            jump();
            return true;
        }

        if (maxJumpHeight >= barrier) {
            // собачка может. Надо тренироваться
            System.out.println(name + " идет тренироваться");
           while (jumpHeight < barrier) {
               train();
           }
           jump();
            System.out.printf("Собака %s перепрыгивает барьер: %d!\n", name, barrier);
            System.out.println("Текущий прыжок: " + jumpHeight);

            return true;

        } else {
            System.out.printf("Барьер высотой %d собака %s взять не может!\n", barrier, name);
            System.out.println("Текущий прыжок: " + jumpHeight);
            return false;
        }

    }

    public String getName() {
        return name;
    }

    public int getJumpHeight() {
        return jumpHeight;
    }

    public String toString() {
        return "Dog " + name + "; current jump: " + jumpHeight;
    }
}
