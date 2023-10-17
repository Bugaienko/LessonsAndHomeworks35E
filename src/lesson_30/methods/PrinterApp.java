package lesson_30.methods;
/*
@date 17.10.2023
@author Sergey Bugaienko
*/

public class PrinterApp {
    public static void main(String[] args) {
        String[] strings = new String[]{"Test", "Abc", "hello", "printer", "Journal"};
        Integer[] integers = new Integer[]{1, 6, 5, -10, 0, 1};

        Printer printer = new Printer();
        printer.<String>printArray(strings);
        System.out.println("============");
        printer.printArray(integers);

        System.out.println(printer.minValue(integers));
        System.out.println(printer.minValue(strings));
        System.out.println("=============");

        System.out.println(printer.sumArray(integers));


//        Printer<String> intPrinter = new Printer<>();
//        intPrinter.print("100");
    }
}
