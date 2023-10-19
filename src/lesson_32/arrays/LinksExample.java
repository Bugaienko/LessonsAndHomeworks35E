package lesson_32.arrays;
/*
@date 19.10.2023
@author Sergey Bugaienko
*/

import java.util.Arrays;

public class LinksExample {
    public static void main(String[] args) {
        int[] first = new int[]{1, 2, 3, 4, 5};
        first[2] = 10;
        System.out.println(first.length);
        System.out.println(Arrays.toString(first));
        System.out.println(first);

        int[] temp;
        temp = first;
        System.out.println(temp);

        temp[2] = 100;
        first[2] = 500;
        System.out.println(Arrays.toString(temp));
        System.out.println(Arrays.toString(first));


        temp = new int[]{0, 1, 2, 3, 4, 5};
        System.out.println(first);
        System.out.println(temp);
        System.out.println(Arrays.toString(temp));
        System.out.println(Arrays.toString(first));


    }
}
