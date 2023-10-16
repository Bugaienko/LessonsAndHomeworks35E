package lesson_29.shapes;
/*
@date 16.10.2023
@author Sergey Bugaienko
*/

/*
Создайте абстрактный класс Shape с абстрактными методами для вычисления площади и периметра.
Реализуйте классы-наследники Circle, Rectangle, и Triangle.
Убедитесь, что все классы правильно вычисляют площадь и периметр.
Создайте массив объектов Shape и вычислите общую площадь и периметр всех фигур в массиве.
 */
public class ShapesApp {
    public static void main(String[] args) {

//        Shape triangle = new Triangle(3, 4, 10);

//        System.out.println(triangle == null);
//        System.out.println(triangle);

        Shape  triangle1 = new Triangle(5,6,8);
        System.out.println(triangle1);
        Shape[] shapes = new  Shape[3];
        shapes[0] = triangle1;
        shapes[1] = new Circle(5.5);
        shapes[2] = new Rectangle(10, 20);

        double sumArea = 0;
        double sumPerimeters = 0;

        for (Shape shape : shapes){
            System.out.println(shape.getClass().getName() + " площадь: " + shape.area());
            System.out.println(shape.getClass().getName() + " периметр: " + shape.perimeter());
            sumArea += shape.area();
            sumPerimeters += shape.perimeter();
        }

        System.out.printf("Сумма площадей %.2f\n", sumArea);
        System.out.printf("Сумма периметров %.2f\n", sumPerimeters);

        TriangleSingle triangleSingle = TriangleSingle.getInstance(3, 6, 11);
        System.out.println(triangleSingle);

        triangle1.testPrint();

    }
}
