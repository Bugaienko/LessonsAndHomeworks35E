package lesson_54.homework53;
/*
@date 22.11.2023
@author Sergey Bugaienko
*/

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
Дан список Person с полями name, age, city.
Используйте Stream API для фильтрации людей,
которые старше определенного возраста и проживают в определенном городе, а затем соберите их в список.
 */
public class Task2 {
    public static void main(String[] args) {

    List<Person> people = new ArrayList<>(List.of(
            new Person("Person1", 21, "Berlin"),
            new Person("Person2", 28, "Paris"),
            new Person("Person3", 25, "London"),
            new Person("Person4", 32, "Berlin")

    ));

    List<Person> personList = people.stream()
            .filter(p -> p.getAge() > 25)
            .filter(p-> p.getCity().equals("Berlin"))
            .collect(Collectors.toList());

        System.out.println(personList);

    }

}
