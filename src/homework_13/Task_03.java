package homework_13;

/**
 * @author Sergii Bugaienko
 */

public class Task_03 {
    public static void main(String[] args) {

        int[] arrA = {1, 4, 5};
        int[] arrB = {2, 3, 6, 7};

        int positionForSearch;
        positionForSearch = 7;
        System.out.println(searchIntByIndex(arrA, arrB, positionForSearch));
    }

    private static int searchIntByIndex(int[] arrA, int[] arrB, int positionForSearch) throws RuntimeException{
        if (positionForSearch > arrA.length + arrB.length || positionForSearch < 1)
            throw new RuntimeException("Error!");
        int cursor = 0;
        int aPos = 0;
        int bPos = 0;


        while (aPos + bPos < positionForSearch) {
            if (aPos < arrA.length && bPos < arrB.length && arrA[aPos] < arrB[bPos]) {
                cursor = 0;
                System.out.print(arrA[aPos] + ", ");
                aPos++;
            } else if (bPos < arrB.length) {
                cursor = 1;
                System.out.print(arrB[bPos] + ", ");
                bPos++;
            } else {
                cursor = 0;
                System.out.print(arrA[aPos] + ", ");
                aPos++;
            }


        }

        System.out.println();
        if (cursor == 1) return arrB[bPos - 1];
        return arrA[aPos - 1];
    }
}
