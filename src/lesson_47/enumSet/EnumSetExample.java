package lesson_47.enumSet;
/*
@date 09.11.2023
@author Sergey Bugaienko
*/

import java.util.EnumSet;
import java.util.Set;

public class EnumSetExample {

    public static void main(String[] args) {
        // allOf(Class) - стат.метод - создает enumSet из всех значений Enum
        Set<Day> days = EnumSet.allOf(Day.class);
        System.out.println(days);

        // of - создает EnumSet из (1-5) enum-ов
        Set<Day> weekend = EnumSet.of(Day.SATURDAY, Day.SUNDAY);
        System.out.println(weekend);

        //range(E from, E to) // оба элемента включительно
        Set<Day> workDays = EnumSet.range(Day.MONDAY, Day.FRIDAY);
        System.out.println(workDays);

        //copyOf(Enum) - создает копию существующего enum
        //copyOf(Collection)

       EnumSet<Day> week = EnumSet.copyOf(workDays);
       week.addAll(weekend);
        System.out.println(week);

        days.remove(Day.MONDAY);
        System.out.println(days);

        for (Day day : days){
            System.out.println(day);
            if (day == Day.SUNDAY){
                days.remove(day);
            }
        }

        System.out.println(days);
    }
}
