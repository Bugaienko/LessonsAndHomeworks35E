package lesson_55.streamsExample;
/*
@date 23.11.2023
@author Sergey Bugaienko
*/

public class Employee {
    private String name;
    private int salary;
    private int age;
    private String position = "developer";
    private String department = "IT";

    public Employee(String name, int salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public Employee(String name, int salary, int age, String position, String department) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.position = position;
        this.department = department;
    }

    @Override
    public String toString() {
        return "{" +
                name +
                " : " + salary +
                " : " + position +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
