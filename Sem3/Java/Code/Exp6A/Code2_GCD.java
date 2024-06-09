package Exp6A;

public class Code2_GCD {
    public static void main(String[] args) {
        System.out.println("Prerna Sunil Jadhav - 60004220127\n");
        int n1 = 4, n2 = 22;
        int gcd = gcd(n1, n2);
        int lcm = lcm(n1, n2);
        System.out.printf("G.C.D of %d and %d is %d.\n", n1, n2, gcd);
        System.out.printf("L.C.M of %d and %d is %d.", n1, n2, lcm);
    }
    static int lcm(int a, int b)
    {
        return (a / gcd(a, b)) * b;
    }
     
    public static int gcd(int n1, int n2)
    {
        if (n2 != 0)
            return gcd(n2, n1 % n2);
        else
            return n1;
    }
}
