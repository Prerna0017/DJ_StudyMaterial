package Exp7;

public class Code1_ConstructorOverloading {
    public static void main(String[] args) {
        System.out.println("Prerna Sunil Jadhav - 60004220127\n");

        Shape rect = new Shape(12, 9);
        System.out.println("Area of Rectangle: "+rect.area+" sq.units.");

        Shape square = new Shape(122);
        System.out.println("Area of Square: "+square.area+" sq.units.");
    }
}

class Shape{
    int area;

    Shape(int length, int breadth){
        this.area = length*breadth;
    }

    Shape(int side){
        this.area = side*side;
    }
}
