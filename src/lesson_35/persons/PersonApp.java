package lesson_35.persons;
/*
@date 23.10.2023
@author Sergey Bugaienko
*/


public class PersonApp {
    public static void main(String[] args) {
        Person person = new Person("email", "password");
        System.out.println(person);
        person.setEmail("email");

        String test = "01@235689";
        System.out.println(test.indexOf('@'));
        System.out.println(test.lastIndexOf('@'));
        System.out.println(test.indexOf('1'));
        System.out.println(test.indexOf('1', 3));

        System.out.println(person);
        person.setEmail("a_sd@fff.ff");
        System.out.println(person);
        System.out.println("=========================");

        String validPassword = "asdf3%AS";
        System.out.println("Previous pass: " + person.getPassword());
        person.setPassword(validPassword);
        System.out.println("current pass: " + person.getPassword());

        String invalidPass = "asdft%Aa";
        person.setPassword(invalidPass);
        System.out.println("current pass: " + person.getPassword());



    }
}
