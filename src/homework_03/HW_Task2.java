package homework_03;
/*
@date 11.09.2023
@author Sergey Bugaienko
*/

/*
Пусть цена товара A обычно составляет 1000 Euro, и товара B составляет 500 Euro.
Если клиент покупает товары вместе, то на них действует скидка 10% на всю покупку.
Выведите на экран переменную, которая соответствует стоимости суммы A+B со скидкой.
Отдельно выведите на экран сумму скидки от этой покупки.
 */
public class HW_Task2 {

    public static void main(String[] args) {
        int priceA = 1000; // лучше сразу деньги хранить в типе данных double или float
        int priceB = 500; // чтобы не потерять центы

        int discount = 10;


        // вычисляем размер скидки в деньгах
        int discountMoney = (priceA + priceB) * discount / 100;
        System.out.println("Вы сэкономили на этой покупке " + discountMoney + " евро");

        // два равнозначных способа посчитать цену товаров с учетом скидки
//        double priceWithDiscount = ((double) priceA + priceB) * (100 - discount) / 100;
        double priceWithDiscount = ((double) priceA + priceB) - discountMoney;
        System.out.println("Размер скидки: " + priceWithDiscount + " Eвро");

    }
}
