public class constOverloaded {
    public static void main(String[] args) {
        Shape square = new Shape(23);
        System.out.println("Area of Square: "+square.area);

        Shape rectangle = new Shape(23,100);
        System.out.println("Area of Rectange: "+rectangle.area);

    }
}

class Shape {
    int area;

    Shape(int side){
        this.area = side*side;
    }

    Shape(int l, int b){
        this.area = l*b;
    }
}
