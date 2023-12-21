package lesson_70;
/*
@date 21.12.2023
@author Sergey Bugaienko
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Generator {
    private final List<String> people = new ArrayList<>(
            List.of("Андрей Милый", "Айсель", "Дмитрий Сагайко", "Максим Айдин", "Максим Сакович",
                    "Михаил Недиогло", "Михаил Гармаш", "Владимир Шабанов")
    );

    public static void main(String[] args) {


        Generator generator = new Generator();
        generate(generator.people);
    }

    private static void generate(List<String> people) {
        Random random = new Random();

        Collections.shuffle(people);
        int index = random.nextInt(people.size());

        System.out.println("От команды знатоков отвечает: " + people.get(index));
    }

    public List<String> getPeople() {
        return people;
    }
}
