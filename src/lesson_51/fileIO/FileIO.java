package lesson_51.fileIO;
/*
@date 16.11.2023
@author Sergey Bugaienko
*/

import java.io.*;
import java.util.Arrays;

public class FileIO {

    public static void main(String[] args) {
        File pathDir = new File("./files");

        // mkdir() - создает директорию. Возвращает boolean. Может создать "конечную" директорию
//        System.out.println(file.mkdir());


        //mkdirs() - создает директорию, включая все необходимые родительские директории
        pathDir = new File("src/lesson_51/db");
        System.out.println(pathDir.mkdirs());

        File file = new File(pathDir, "text.txt");

        //delete() - удаляет файл или директорию
//        System.out.println(file.delete());

        // deleteOnExit(); - удаляет файл или директорию при завершении работы виртуальной машины

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //exists() - проверяет существует ли файл или директория
        System.out.println("exists: " + file.exists());

        //isFile, isDirectory - возвращает true, если объект File является файлом / директорией
        System.out.println("isFile: " + file.isFile());
        System.out.println("isDirectory: " + file.isDirectory());
        System.out.println("isDirectory: " + pathDir.isDirectory());
        System.out.println("isHidden: " + file.isHidden()); // проверяет, является ли файл / директория скрытым

        System.out.println("length: " + file.length()); // размер файла в байтах
        System.out.println("lastModified: " + file.lastModified()); // время последнего изменения файла

        System.out.println("getName: " + file.getName()); // возвращает имя файла или директории
        System.out.println("getPath: " + file.getPath()); // возвращает строковое представление пути к файлу

        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("Hello, Java");

            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try( FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader))
        {
            String line;
            line = bufferedReader.readLine();
            System.out.println("Чтение завершено!");
            System.out.println(line);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // String[] list() - возвращает список имен файлов и директорий в директории
        String[] names = pathDir.list();
        System.out.println("names: " + Arrays.toString(names));

        //File[] listFiles() - возвращает массив объектов типа File представляющий файлы в директории
        File[] files = pathDir.listFiles();
        for (File file1: files) {
            System.out.println(file1.getName() + " : " + file1.getPath());
        }


    }
}
