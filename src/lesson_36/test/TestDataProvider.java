package lesson_36.test;
/*
@date 25.10.2023
@author Sergey Bugaienko
*/

import lesson_36.persons.Person;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class TestDataProvider {
    static Stream<Arguments> dataForTestStreamsFromClass() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 5, 6}, "Hello", true, new Person("trrt", "trrt")),
                Arguments.of(new int[]{0, 2, 4, 6}, "Java", false, null),
                Arguments.of(new int[]{5, 66, 7, 13, 2}, "Test data", true, null)
        );
    }
}
