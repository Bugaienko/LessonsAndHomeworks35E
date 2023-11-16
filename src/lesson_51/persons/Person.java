package lesson_51.persons;
/*
@date 15.11.2023
@author Sergey Bugaienko
*/

import java.util.Comparator;
import java.util.List;

public class Person {
    private String email;
    private String password;

    public Person(String email, String password) {
        setEmail(email);
        setPassword(password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        try {
            EmailValidator.validate(email);
            System.out.println("Email прошел проверку");
            this.email = email;
        } catch (EmailValidateException e) {
            System.out.println("Email НЕ прошел проверку");
            e.printStackTrace();
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        try {
            PasswordValidator.validate(password);
            this.password = password;
            System.out.println("Пароль прошел проверку");
        } catch (PasswordValidateException e) {
            System.out.println("Пароль проверку НЕ прошел");
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "email='" + email + '\'' +
                '}';
    }

}
