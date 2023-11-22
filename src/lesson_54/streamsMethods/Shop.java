package lesson_54.streamsMethods;
/*
@date 22.11.2023
@author Sergey Bugaienko
*/

import java.util.List;

public class Shop {
    private String title;
    private List<String> products;

    public Shop(String title, List<String> products) {
        this.title = title;
        this.products = products;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "title='" + title + '\'' +
                ", products=" + products +
                '}';
    }
}
