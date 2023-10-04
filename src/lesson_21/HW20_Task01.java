package lesson_21;

/*
@date 04.10.2023
@author Sergey Bugaienko
*/
/*
Написать класс Employee (Работник) У него должны быть поля имя, возраст, зарплата

Инкапсулировать класс. Написать метод info() выводящий информацию о работнике.
 */
public class HW20_Task01 {

    private String name;
    private int age;
    private double salary;

    public HW20_Task01(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void info() {
        System.out.printf("Employee %s; age: %d; salary: %.2f", name, age, salary);
    }

}
