package lesson_39.dateArrays;
/*
@date 30.10.2023
@author Sergey Bugaienko
*/

/*
Написать метод, принимающий массив или MyArrayList (наш самописный резиновый массив) из нескольких дат типа LocalDate
и возвращающий количество дней между самой ранней и поздней датами в этом списке
 */



import lesson_35.myArrayList.MyArrayList;
import lesson_35.myArrayList.MyList;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateUtil {

    public static void main(String[] args) {
        MyList<LocalDate> dates = new MyArrayList<>();
        dates.add(LocalDate.of(2022, 1, 1));
        dates.add(LocalDate.of(2023, 12, 30));
        dates.add(LocalDate.of(2023, 5, 15));
        dates.add(LocalDate.of(2024, 1, 1));

        System.out.println(DateUtil.durationBetweenMinMaxDate(dates));
     }

    public static long durationBetweenMinMaxDate(MyList<LocalDate> datesList) {
        if (datesList == null || datesList.isEmpty()) return 0;


        LocalDate minDate = datesList.get(0);
        LocalDate maxDate = datesList.get(0);

        for (LocalDate date : datesList) {
            if (date.isBefore(minDate)) {
                minDate = date;
            }

            if (date.isAfter(maxDate)) {
                maxDate = date;
            }
        }

        return minDate.until(maxDate, ChronoUnit.DAYS);
    }
}
