package lesson_50.hashMapImp;
/*
@date 14.11.2023
@author Sergey Bugaienko
*/

import org.junit.platform.engine.support.hierarchical.Node;

import java.util.*;

public class MyHashMap<K, V> implements InterfaceHashMap<K, V> {

    private Node<K, V>[] buckets;
    private int capacity = 16;
    private double loadFactor = 0.75;
    private int size;

    public MyHashMap() {
        this.buckets = (Node<K, V>[]) new Node[capacity];
    }

    /*
    1. Вычислить хэш-код ключа.
    2. На основание кэша определить индекс корзины в массиве.
    3. Если в корзине еще нет элементов - положить новую пару ключ-значение
    4. Если в корзине есть элементы: пройти по цепочке элементов, проверить ключи на совпадение.
    4.1. Если ключи совпадают - обновить значение для соответствующего ключа
    4.2. Если не найдено совпадений ключей - приклеить новую пару в конец списка
     */
    @Override
    public V put(K key, V value) {
        int index = getIndex(key);
        Node<K, V> current = buckets[index];

        //проверяем наличие цепочки нод и сверяем ключи (п.4 + п4.1)
        while (current != null) {

            //обрабатываем ситуацию key = null
            if (current.key == null && key == null) {
                current.value = value;
                return value;
            }

            //сверяем ключи
            if (current.key != null && current.key.equals(key)) {
                current.value = value;
                return value;
            }

            // надо зафиксировать последнюю ноду в цепочке
            if (current.next == null) {
                break;
            }

            current = current.next;
        }

        // создаю новую пару ключ значение
        Node<K, V> newNode = new Node<>(key, value);

        // проверка наличия цепочки в ячейке (п.3 план)
        if (current == null) {
            // значит под индексом пустая ячейка
            buckets[index] = newNode;
        } else {
            //в ячейке была как минимум 1 нода. Надо приклеить новую ноду в конец цепочки (п.4.2)
            current.next = newNode;
        }

        size++;

        // проверка загрузки

        if (1.0 * size / capacity >= loadFactor) {
            resize();
        }
        return value;
    }

    /*
    Для получения значения по ключу
    1. Получить хэш ключа. Определить индекс ячейки в массиве
    2. Проводится поиск в этой ячейке. Если элемент/ы присутствуют, сверить ключи для каждого?
    2.1. если ключи совпали - вернуть значение
    2.2. если не совпали - вернуть null
     */
    @Override
    public V get(Object key) {

        int index = key != null ? key.hashCode() & (capacity - 1) : 0;
        Node<K, V> current = buckets[index];

        while (current != null) {

            if (current.key == null && key == null) {
                return current.value;
            }

            if (current.key != null && current.key.equals(key)) {
                return current.value;
            }

            current = current.next;
        }

        return null;
    }

    /*
    1. Надо проверить если в карте нода с соответсвующий ключом
    2. Если есть - удалить эту, вернув значение, которое соответствовало ключу
    2.1. Если нет - вернуть нал
     */
    @Override
    public V remove(Object key) {
        /*
        1. Получить индекс
        2. Пройти по всем нодам в цепочке, сравнить ключи
         */

        int index = key == null ? 0 : key.hashCode() & (capacity - 1);

        Node<K, V> current = buckets[index];


        Node<K, V> previous = null;
        while (current != null) {

            if (current.key == null && key == null) {
                return removeNode(previous, current, index);
            }

            if (current.key != null && current.key.equals(key)) {
                return removeNode(previous, current, index);
            }

            previous = current;
            current = current.next;
        }


        return null;
    }

    private V removeNode(Node<K, V> previous, Node<K, V> current, int index) {
        /* Для удаления ноды нам нужно знать:
        1. Есть ли нода перед удаляемой
        2. Под каким индексом в массиве она находится
        3. Ссылка на саму удаляемую ноду.
         */

        V value = current.value;

        // проверяем есть ли нода перед
        if (previous == null) {
            //удаляемая нода первая в цепочке
            buckets[index] = current.next;
        } else {
            //перед удаляемой есть нода
            previous.next = current.next;
        }

        size--;
        return value;
    }

    @Override
    public Set<K> keySet() {
        Set<K> result = new HashSet<>();
        for (Node<K, V> node : buckets) {
            while (node != null) {
                result.add(node.key);
                node = node.next;
            }
        }

        return result;
    }

    @Override
    public Collection<V> values() {
        Collection<V> result = new ArrayList<>();
        for (Node<K, V> node : buckets) {
            while (node != null) {
                result.add(node.value);
                node = node.next;
            }
        }
        return result;
    }

    @Override
    public boolean containsKey(Object key) {
        /*
        1. Получить хэш ключа и индекс
        2. Пройти по цепочке, проверить ключи на равенство
         */

        int index = getIndexObject(key);
        Node<K, V> current = buckets[index];

        while (current != null) {
            if (Objects.equals(current.key, key)) return true;
            current = current.next;
        }
        return false;
    }

    @Override
    public void clear() {
        capacity = 16;
        buckets = (Node<K, V>[]) new Node[capacity];
        size = 0;
    }

    @Override
    public V getOrDefault(Object key, V defaultValue) {
        V value = get(key);
        return value != null ? value : defaultValue;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void resize() {
        System.out.println("\nПересчет карты==============\n");
        // TODO увеличить массив, перераспределить элементы
        /*
        1. Увеличить capacity
        2. Создать новый массив
        3. Пересчитать хэши и индексы для всех существующий пар
        4. Перекинуть ссылки массивов
         */

        capacity = capacity * 2;
        Node<K, V>[] newBuckets = (Node<K, V>[]) new Node[capacity];

        for (Node<K, V> node : buckets) {
            Node<K, V> current = node;

            while (current != null) {
                // запоминаю следующую в цепочке ноду
                Node<K, V> next = current.next;

                int newIndex = getIndex(current.key); // новый индекс

                // Option 1
                current.next = null;

                Node<K, V> cursor = newBuckets[newIndex];

                second:
                while (cursor != null) {
                    if (cursor.next == null) break second;
                    cursor = cursor.next;
                }
                if (cursor == null) {
                    newBuckets[newIndex] = current;
                } else {
                    cursor.next = current;
                }
                // End Option1


                // Option2
                // к текущей новой ноде привешиваю в "next" то, что сейчас уже есть в этой ячейке в новом массиве
//                current.next = newBuckets[newIndex];
//                newBuckets[newIndex] = current;
                // End Option2


                current = next; // берем запомненную "следующую" ноду
            }

        }

        System.out.println("Пересчет завершен");

        buckets = newBuckets;


    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (Node<K, V> node : buckets) {
            if (node != null) {
                sb.append(node.getList());
            }
        }

        return sb.append("]").toString();
    }

    private int getIndex(K key) {
        //проверка ключа на null
        if (key == null) return 0;


//        int hashCode = key.hashCode();
//        int index = Math.abs(hashCode) % capacity;
        // capacity ДОЛЖНО быть степенью двойки
        int index = key.hashCode() & (capacity - 1);
//        System.out.println("index: " + index);
        return index;
    }

    private int getIndexObject(Object key) {
        return key != null ? key.hashCode() & (capacity - 1) : 0;
    }

    @Override
    public int size() {
        return size;
    }

    private static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" +
                    key +
                    ": " + value +
                    '}';
        }

        public String getList() {
            Node<K, V> cursor = this;
            StringBuilder sb = new StringBuilder("[");
            while (cursor != null) {
                sb.append(cursor);
                sb.append(", ");
                cursor = cursor.next;
            }

            sb.setLength(sb.length() - 2);
            return sb.append("]").toString();

        }
    }

}
