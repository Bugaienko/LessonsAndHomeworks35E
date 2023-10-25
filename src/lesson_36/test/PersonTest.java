package lesson_36.test;

import lesson_36.persons.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

class PersonTest {

    Person person;
    String startEmail = "john@test.com";
    String startPassword = "qwerty1Q!";




//    @BeforeAll // этот метод выполнится один раз перед запуском всех тестов (тестовых методов)
//    void beforeAll(){
//
//    }
    // @AfterEach // метод выполнится после каждого теста
    //@AfterAll // метод выполнится один раз после всех тестов


    @BeforeEach // метод выполняется перед каждым тестом
    void setUp() {
        person = new Person(startEmail, startPassword);
    }

    @Test
        // указывает, что метод является тестовым
    void testSetValidEmail() {
        String validEmail = "valid@test.de";
        person.setEmail(validEmail);
        Assertions.assertEquals(validEmail, person.getEmail());
    }



    // @Disabled // указывает, что тест (или группа тестов) отключены и не будут выполняться
    @Test
    //    отсутствует @
    void testInvalidEmail() {
        String incorrectEmail = "invalid.test.de";
        person.setEmail(incorrectEmail);
        Assertions.assertEquals(startEmail, person.getEmail());
    }

    @Test
        // больше одного символа @
    void testInvalidEmailTwoAtSet() {
        String incorrectEmail = "inva@lid@test.de";
        person.setEmail(incorrectEmail);
        Assertions.assertEquals(startEmail, person.getEmail());
    }

    @ParameterizedTest // могут иметь разнообразные источники данных. Например, массив (примитивы + String)
    @ValueSource(strings = {"invalid@testd.e", "invalid@testde.", "invalid@testde"})
    void testIncorrectEmailSetParam(String incorrectEmail) { // в переменную incorrectEmail одна за другой присваиваются значения из набора данных
        //System.out.println("Current value for test: " + incorrectEmail);
        person.setEmail(incorrectEmail);
        Assertions.assertEquals(startEmail, person.getEmail());
    }

    // @EnumSource(TestEnum.class) // источник данных для перечислений
    @ParameterizedTest // источник тестовых данных - метод
    @MethodSource("generateDataForEmailTest")
    void testIncorrectEmailSetParamMethodSource(String incorrectEmail){
        person.setEmail(incorrectEmail);
        Assertions.assertEquals(startEmail, person.getEmail());
    }
    static Stream<String> generateDataForEmailTest() { // метод возвращающий поток данных для теста
        return Stream.of("inva!lid@test.de", "invalid@te*st.de",
                "inva lid@test.de", "invalid@test.d#e", "invalid@te$st.de");
        // TODO насколько корректно использование не английского алфавита?
        // "invaДid@test.de", "inva게id@test.de"
    }


    @Disabled
    @ParameterizedTest
    @ValueSource(ints = {1,2,3}) //массив интов в качестве тестовых данных
    void testIntsParam(int value) {
        Assertions.assertTrue(value <= 2);
        Assertions.assertFalse(value < 2);
    }

    @Disabled
    @ParameterizedTest
    @CsvSource({"apple, 1, true", "banana, 4, false", "cherry, 5, false"}) //источник данных в формате CSV (Comma-Separated-Values)
    void testCSVsource(String fruit, int count, boolean flag){
        Assertions.assertNotNull(fruit);
        Assertions.assertTrue(count> 0);
        Assertions.assertFalse(flag);
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv") // источник данных файл в формате CSV
    void testDataFromFile(String fruit, int count, boolean flag){
        Assertions.assertNotNull(fruit);
        Assertions.assertTrue(count> 0);
        Assertions.assertFalse(flag);
    }




}