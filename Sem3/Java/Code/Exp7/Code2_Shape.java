package Exp7;
import java.util.*;
class Rect {
    private int l, b;
    Rect(int l, int b) {
        this.l = l;
        this.b = b;
    }
    int area() {
        return l * b;
    }
}
class Cube {
    private int side;
    Cube(int side) {
        this.side = side;
    }
    int volume() {
        return side * side * side;
    }
}
class Size {
    public static int size(Object o) {
        if (o instanceof Rect) {
            return ((Rect) o).area();
        } else if (o instanceof Cube) {
            return ((Cube) o).volume();
        } else {
            return -1;
        }
    }
}
public class Code2_Shape {
    public static void main(String[] args) {
        System.out.println("Prerna Jadhav - 60004220127");
        Scanner sc = new Scanner(System.in);
        Rect r = new Rect(5, 6);
        Cube c = new Cube(4);
        System.out.println("Area of Rectangle : " + Size.size(r));
        System.out.println("Volume of Cube : " + Size.size(c));
        System.out.println("Other objects : " + Size.size(sc));
    }
}
