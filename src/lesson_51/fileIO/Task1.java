package lesson_51.fileIO;
/*
@date 16.11.2023
@author Sergey Bugaienko
*/

import java.io.*;

public class Task1 {
    public static void main(String[] args) {
        /*
        Создайте 10 файлов: test_1.txt, test_2.txt ...
        В каждый файл записать строку соответственно: Java1, Java2...
         */
        File pathDir = new File("src/lesson_51/db");

        for (int i = 1; i < 11; i++) {
            File file = new File(pathDir, "test_" + i + ".txt");

            try (FileWriter writer = new FileWriter(file)) {
                file.createNewFile();
                writer.write("Java" + i);

            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }


        // Проверьте все файлы в директории.
        // (получить список всех файлов в директории, залезть в каждый. Считать строку)
        // Выведите имя файла, в котором содержится строка "Java7"
        // Output: test_7.txt

        File[] files = pathDir.listFiles();

        for (File file : files) {

            try (
                    FileReader fileReader = new FileReader(file);
                    BufferedReader br = new BufferedReader(fileReader)
            ) {

                String line = br.readLine();

                if (line != null && line.contains("Java7")) {
                    System.out.println("Файл найден: " + file.getName());
                }

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }

    }
}
