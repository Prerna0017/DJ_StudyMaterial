public class Abstract {
    public static void main(String[] args) {
        Shape s = new Shape();
        System.out.println(s.circleArea(10));
        System.out.println(s.rectArea(100,10));
        System.out.println(s.triangleArea(10,100));
    }
}

abstract class Area{
    abstract double circleArea (int r);
    abstract double rectArea (int l, int b);
    abstract double triangleArea (int h, int b);
}

class Shape extends Area{

    @Override
    double circleArea(int r) {
        return (Math.PI*r*r);
    }

    @Override
    double rectArea(int l, int b) {
        return (l*b);
    }

    @Override
    double triangleArea(int h, int b) {
        return ((0.5)*h*b);
    }
}
