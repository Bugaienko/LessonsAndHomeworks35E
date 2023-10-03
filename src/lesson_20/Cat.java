package lesson_20;
/*
@date 02.10.2023
@author Sergey Bugaienko
*/

public class Cat {

    // мы закрыли прямой доступ к полям класса
    private String name = "Max";
    private int age;
    private int weight;

    public Cat(String name, int age, int weight) {
//        this.name = name;
//        this.age = age;
//        this.weight = weight;

        setName(name);
//        if (this.name == null || this.name.isEmpty()) {
//            this.name = "Tim";
//        }
        setAge(age);
        setWeight(weight);
    }


    // вызвать приватный метод можно только внутри этого класса
    private void sayMeow() {
        System.out.println("Meow! " + name);

    }

    public void setWeight(int weight) {
        if (weight >= 0 && weight <= 50) {
            this.weight = weight;
        }
    }

    public void setName(String newName) {
        if (newName != null && !newName.isEmpty()) {
            this.name = newName;
        }
        sayMeow();
    }

    public void setAge(int newAge) {
        if (newAge >= 0 && newAge <= 20) {
            this.age = newAge;
        }
    }

    //Getter для поля name
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

}
