package lesson_37.javaTimeApi;
/*
@date 26.10.2023
@author Sergey Bugaienko
*/

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TimeApiExample {
    public static void main(String[] args) {

        //  LocalDate - представляет дату (год, месяц, число)
        LocalDate date = LocalDate.now(); // возвращает текущую дату
        System.out.println(date);
        LocalDate tomorrow = date.plusDays(1); // прибавляет 1 день к date
        System.out.println(date);
        System.out.println("tomorrow: " + tomorrow);
        System.out.println(date.plusDays(1));
        System.out.println("plusWeeks: " + date.plusWeeks(4)); // плюс 4 недели к текущей дате
        System.out.println("yesterday" + date.minusDays(1)); // минус 1 день
        LocalDate date1 = LocalDate.of(2002, 2, 15); // установить дату (год, месяц, число)
        System.out.println(date1);
        System.out.println(" ===================== \n");
        LocalDate date2 = LocalDate.of(2002, Month.FEBRUARY, 15);

        System.out.println("год: " + date2.getYear() + "; месяц: " + date2.getMonth() + "; число: " + date2.getDayOfMonth() + "; это была: " + date2.getDayOfWeek());
        System.out.println("день года: " + date2.getDayOfYear() + "; номер месяца: " + date2.getMonthValue());

        String dateString = "2000-10-25";
        LocalDate date3 = LocalDate.parse(dateString);
        System.out.println(date3.getYear() + " : " + date3.getMonth() + " : " + date3.getDayOfMonth());

        System.out.println(" ================= LocalTime====================");
        //  LocalTime - представляет время (часы, минуты, секунды, наносекунды)
        LocalTime time = LocalTime.now();
        System.out.println(time);
        LocalTime time1 = LocalTime.of(21, 33);
        time1 = LocalTime.of(21, 33, 44);
        time1 = LocalTime.of(21, 33, 44, 54875);
        System.out.println(time1);
        System.out.println("plusHours(1): " + time.plusHours(1));
        System.out.println("plusMinutes(65): " + time.plusMinutes(65));
        System.out.println("minusSeconds(30): " + time.minusSeconds(30));
        System.out.println(time.getHour() + " | " + time.getMinute() + " | " + time.getSecond() + " | " + time.getNano());
        String timeString = "12:13:45";
        LocalTime parseTime = LocalTime.parse(timeString); // ожидает String в формате ISO-8601 ("2001-01-15T08:15:45+01:00")
        System.out.println(parseTime.getHour() + " | " + parseTime.getMinute() + " | " + parseTime);

        System.out.println(" ================= LocalDateTime====================\n");

        // LocalDateTime - представляет дату и время без учета часового пояса
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);
        LocalDate localDate = LocalDate.of(2011, Month.AUGUST, 15);
        LocalTime localTime = LocalTime.of(15, 31, 59);
        LocalDateTime dateTime1 = LocalDateTime.of(localDate, localTime);
        System.out.println("dateTime1- " + dateTime1);
        dateTime1 = LocalDateTime.of(2023, 12, 31, 23, 59);
        System.out.println(dateTime1.getDayOfWeek().getValue());
        System.out.println(dateTime1.plusHours(1));

        System.out.println("===============ZonedDateTime===============\n");
        // ZonedDateTime - представляет дату и время с часовым поясом
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime + " | " + zonedDateTime.getZone());

        System.out.println("========== isAfter, isBefore, until =====================\n");
        LocalDate date4 = LocalDate.of(2020, 10, 15);
        LocalDate date5 = LocalDate.of(2020, 6, 25);

        // isAfter, isBefore, equals, until есть у всех объектов представляющих дату и/или время
        // isAfter - проверяет, что текущий объект после (позже) указанного объекта
        boolean isAfter = date4.isAfter(date5);
        System.out.println("date4.isAfter(date5): " + isAfter);

        //isBefore - проверяет, что текущий объект до (раньше) указанного объекта (даты или времени)
        System.out.println("date4.isBefore(date5): " + date4.isBefore(date5));

        //equals - проверяет даты/время на равенство
        System.out.println("date4.equals(date5): " + date4.equals(date5));

        //until - метод измеряет время между текущим и указанным объектом даты/времени -> long
        long daysBetween = date4.until(date5, ChronoUnit.DAYS);
        System.out.println("daysBetween: " + daysBetween);
        System.out.println(date4.until(date5, ChronoUnit.MONTHS));
        LocalDateTime dateTime2 = LocalDateTime.now();
        LocalDateTime dateTime3 = dateTime2.minusDays(15);
        System.out.println(dateTime2.until(dateTime3, ChronoUnit.NANOS));

        long hoursBetween = ChronoUnit.HOURS.between(dateTime2, dateTime3);
        System.out.println(hoursBetween);

        System.out.println(" ==================== Duration===============\n");
        // Duration  представляет продолжительность в секундах и наносекундах

        Instant start = Instant.now();
        //Здесь какой-то ко
        int sum = 0;
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < i; j++) {
                sum += j;
            }
        }
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        long millis = duration.toMillis();
        long seconds = duration.toSeconds();
        System.out.println(millis + " | " + seconds);
        System.out.println(duration.getNano());

        System.out.println("==============Period ======================\n");
        LocalDate startDate = LocalDate.of(2022, Month.JANUARY, 1);
        LocalDate endDate = LocalDate.of(2023, Month.DECEMBER, 31);
        Period period = Period.between(startDate, endDate);
        System.out.println(period);
        System.out.println(period.getYears() + " | " + period.getMonths() + " | " + period.getDays());
        System.out.println(period.toTotalMonths());


        System.out.println("====================DateTimeFormatter========\n");
        // DateTimeFormatter - форматирование даты и времени
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy h:mm:ss a");
        String formattedDate = now.format(formatter);
        System.out.println("formattedDate: " + formattedDate);
       // String dateForParse = "23-10-26 19:15";
        String dateForParse = "23-10-26 19:15";
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm");
        LocalDateTime parsedDateTime = LocalDateTime.parse(dateForParse, formatter1);
        System.out.println(parsedDateTime.format(formatter));

        /*
        y - год
        M - месяц
        d - день
        H - час в формате от 0 до 23
        h - в формате от 0 до 12, флаг 'a' для отображения AM/PM
        m - минута
        s - секунда
         */

        // Количество повторений символа определяет формат
        /*
        yy - двухзначный год, например "23" для 2023
        yyyy - 4-значный год - 2023
        M - месяц : "2" или "12"
        MM - двухзначный месяц: "02" или "12"
        d - однозначный или двухзначный день "3" или "31"
        dd -  двухзначный день: "03" или "31"

         */

        // "15-12-2022 20-46"
        // запарсить строку в формат LocalDateTime
        // распечатать + отдельно мясяц, день, час
        // "13-01-2023 00-47" запарсить
        // какому дню недели соответствует вторая дата
        // сколько дней между этими датами
        System.out.println(" ==================== Task1 ==================\n");

        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm");
        String dateStr1 = "15-12-2022 20-46";
        String dateStr2 = "13-01-2023 00-47";
        LocalDateTime dateFromStr1 = LocalDateTime.parse(dateStr1, formatter2);
        LocalDateTime dateFromStr2 = LocalDateTime.parse(dateStr2, formatter2);
        System.out.println(dateFromStr1);
        System.out.println(dateFromStr1.getMonth() + " : " + dateFromStr1.getDayOfMonth() + " : " + dateFromStr1.getHour());
        System.out.println(dateFromStr2.getDayOfWeek());
        System.out.println(dateFromStr1.until(dateFromStr2, ChronoUnit.DAYS));

        //
        System.out.println(dateFromStr1.minus(10, ChronoUnit.MINUTES));


    }
}
