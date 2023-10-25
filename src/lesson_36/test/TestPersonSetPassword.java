package lesson_36.test;
/*
@date 25.10.2023
@author Sergey Bugaienko
*/

import lesson_36.persons.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class TestPersonSetPassword {
    Person person;
    String startEmail = "john@test.com";
    String startPassword = "qwerty1Q!";

    @BeforeEach
    void setUp() {
        person = new Person(startEmail, startPassword);
    }

    @ParameterizedTest
    @MethodSource("getIncorrectPasswords")
    void testSetIncorrectPassword(String incorrectPass) {
        boolean isPassApply = person.setPassword(incorrectPass);
        assertEquals(startPassword, person.getPassword());
        assertFalse(isPassApply);
    }

    static Stream<String> getIncorrectPasswords() {
        return Stream.of(
                "qwerty1@", "wertY1@", "qWerty1#", "qwerty1Q!"
        );
    }

    //"qwer tY3@$",

    @ParameterizedTest
    @ValueSource(strings = {"asdfQ!3a", "as%dfQ0a", "as$dfQ7a", "@asdfJ1a", "asdfT9a&", "ASDFQ@5a"})
    void testSetValidPassword(String validPass) {
        boolean isPassApply = person.setPassword(validPass);
        assertTrue(isPassApply);
        assertEquals(validPass, person.getPassword());
    }

}

    /*
    Требования к валидному password
    1. длина >= 8
    2. мин 1 цифра
    3. мин 1 маленькая буква
    4. мин 1 большая буква
    5. мин 1 спец.символ ("!%$@&")
    6. Пароль должен содержать ТОЛЬКО вышеуказанные символы (алфавит, цифры или !%$@&)
     */