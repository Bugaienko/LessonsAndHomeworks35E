package lesson_50.test;
/*
@date 15.11.2023
@author Sergey Bugaienko
*/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class TestCollection {

    private List<String> strings1;
    private List<String> strings2;
    private List<String> strings3;
    private List<String> strings4;


    @BeforeEach
    void setUp(){
        strings1 = List.of("Banana", "Apple", "Orange", "Lime");
        strings2 = List.of("Banana",  "Orange", "Apple", "Lime");
        strings3 = List.of("Banana", "Apple", "Orange", "Lime", "Cherry");
        strings4 = List.of("Banana", "Apple", "Orange", "Lime");
    }

    // List -> assertEquals для списков, проверяет содержат ли два списка одни и те же элементы в одном и том же порядке
    @Test
    void listEquals(){
        assertNotEquals(strings1, strings2);
        assertEquals(strings1, strings4);
    }

    //Set -> assertEquals для множеств, проверяет содержат ли два множества одни и те же элементы независимо от порядка
    @Test
    void setEquals() {
        Set<String> set1 = new LinkedHashSet<>(strings1);
        Set<String> set2 = new LinkedHashSet<>(strings2);
        Set<String> set3 = new LinkedHashSet<>(strings3);

        System.out.println(set1);
        System.out.println(set2);

        assertEquals(set1, set2);
        assertNotEquals(set1, set3);

    }

    //Map -> аналогично Set -> проверяет содержат ли двк карты одинаковый набор пар ключ-значение. Порядок не важен

    //Общие утверждения для всех коллекций
    @Test
    void collectionAssert(){
        assertFalse(strings1.isEmpty());
        assertEquals(4, strings1.size());
        assertTrue(strings1.contains("Apple"));
        //только для списков String
//        assertLinesMatch(strings1, strings2);
        assertLinesMatch(strings1, strings4);
    }

    @Test
    void  exceptionThrows(){

    }
}
