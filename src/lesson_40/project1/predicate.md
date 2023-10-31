## Predicate

`Predicate` в Java - это функциональный интерфейс, который представляет собой условие или предикат, принимающий один аргумент и возвращающий значение типа `boolean`. Он определен в пакете `java.util.function` и содержит один метод `test`, который оценивает условие на заданном аргументе.

Напомню, функциональные интерфейсы – это интерфейсы, которые содержат ровно один абстрактный метод.


Под "предикатом" понимается функция, которая принимает один аргумент и возвращает значение типа `boolean`. То есть это функция, которая выполняет какое-то условие и возвращает `true`, если условие выполняется, и `false` в противном случае.

Функциональный интерфейс `Predicate<T>` предоставляет метод `test(T t)`, который выполняет тестирование объекта типа `T` и возвращает `true` или `false`.

Примеры использования предиката:

- Проверка, является ли число положительным;
- Проверка, является ли строка пустой;
- Проверка, является ли значение в поле `age` объекта типа `Person` меньше 21;

Если обобщить предикат используется для **Проверки, соответствует ли объект заданным критериям**.


Прототип метода `test` выглядит следующим образом:

```
boolean test(T t);
```

Где `T` - тип входного аргумента.

Пример использования `Predicate`:

```
Predicate<String> isNotEmpty = s -> !s.isEmpty();
System.out.println(isNotEmpty.test("Hello"));  // Выводит true
System.out.println(isNotEmpty.test(""));       // Выводит false
```

```

public class PredicateExample {
    public static void main(String[] args) {
        Predicate<String> isLongerThan3 = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() > 3;
            }
        };
        
        System.out.println(isLongerThan3.test("foo"));  // Выведет: false
        System.out.println(isLongerThan3.test("foobar"));  // Выведет: true
        
       
    }
}
```

### Использование лямбда-выражения
```
Predicate<Integer> isPositive = x -> x > 0;
System.out.println(isPositive.test(-10));  // Выведет: false
System.out.println(isPositive.test(10));  // Выведет: true
```
