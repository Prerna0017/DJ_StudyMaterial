package Exp6A;

class Code3_Power {
    public static void main(String[] args) {
        System.out.println("Prerna Sunil Jadhav - 60004220127\n");
        int base = 3, powerRaised = 4;
        int result = power(base, powerRaised);
        System.out.println(base + "^" + powerRaised + "=" + result);
    }

    public static int power(int base, int powerRaised) {
        if (powerRaised != 0) {
            // recursive call to power()
            return (base * power(base, powerRaised - 1));
        } else {
            return 1;
        }
    }
}
