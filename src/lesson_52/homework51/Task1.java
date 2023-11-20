package lesson_52.homework51;
/*
@date 20.11.2023
@author Sergey Bugaienko
*/

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task1 {

    private static final int LIMIT = 2000;

    private static final String FILE_DATA = "src/lesson_52/homework51/files/data.txt";
    private static final String FILE_LESS = "src/lesson_52/homework51/files/less.txt";
    private static final String FILE_MORE = "src/lesson_52/homework51/files/more.txt";
    public static void main(String[] args) {

        List<String> records = readData();
        System.out.println(records);

        Map<String, Integer> users = listToMap(records);
        System.out.println(users);

        writeFiles(users);
    } // main

    private static void writeFiles(Map<String, Integer> users) {
        try (BufferedWriter less = new BufferedWriter(new FileWriter(FILE_LESS));
        BufferedWriter more = new BufferedWriter(new FileWriter(FILE_MORE))) {

            for (Map.Entry<String, Integer> entry : users.entrySet()){

//                BufferedWriter writer;
//                if (entry.getValue() < LIMIT) {
//                    writer = less;
//                } else {
//                    writer = more;
//                }


//                BufferedWriter writer = entry.getValue() < LIMIT ? less : more;
                String data = entry.getKey() + ":" + entry.getValue();

                if (entry.getValue() < LIMIT) {
                    less.write(data);
                    less.newLine();
                } else {
                    more.write(data);
                    more.newLine();
                }

//                writer.write(data);
//                writer.newLine();
            }
            System.out.println("Запись в файлы завершена");
    }  catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static Map<String, Integer> listToMap(List<String> records) {
        Map<String, Integer> users = new HashMap<>();

        for (String record : records) {
            DataTransfer dataTransfer = new DataTransfer(record);

            String name = dataTransfer.getUserName();
            int amount = dataTransfer.getValue();

            users.compute(name, (key, value) -> value == null ?
                    amount : value + amount);
        }

        return users;
    }

    private static List<String> readData() {
        List<String> result = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_DATA))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.add(line);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;

    }


}
