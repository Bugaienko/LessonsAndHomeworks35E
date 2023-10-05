package lesson_22;

/*
@date 04.10.2023
@author Sergey Bugaienko
*/
/*
Написать класс Employee (Работник) У него должны быть поля имя, возраст, зарплата

Инкапсулировать класс. Написать метод info() выводящий информацию о работнике.


Добавить в Employee уникальный идентификатор каждому сотруднику
 */
public class Employee {

    private int id;
    private String name;
    private int age;
    private double salary;

    private static int counterForId;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.id = counterForId++;
    }

    public int getId() {
        return id;
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
        System.out.printf("Employee id:%d %s; age: %d; salary: %.2f\n", id, name, age, salary);
    }

}
