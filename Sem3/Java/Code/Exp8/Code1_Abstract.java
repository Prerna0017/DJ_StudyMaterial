package Exp8;
import java.lang.Math;
abstract class Shape {
    abstract void area();
    double area;
}
class Triangle extends Shape {
    double b = 50, h = 15;
    void area() {
        area = (b * h) / 2;
        System.out.println("area of Triangle -->" + area);
    }
}
class Rectangle extends Shape {
    double w = 70, h = 20;
    void area() {
        area = w * h;
        System.out.println("area of Rectangle -->" + area);
    }
}
class Circle extends Shape {
    double r = 5;
    void area() {
        area = Math.PI * r * r;
        System.out.println("area of Circle -->" + area);
    }
}
class Exp8_Abstract {
    public static void main(String[] args) {
        System.out.println("Prerna Jadhav 60004220127");
        Triangle t = new Triangle();
        Rectangle r = new Rectangle();
        Circle c = new Circle();
        t.area();
        r.area();
        c.area();
    }
}
