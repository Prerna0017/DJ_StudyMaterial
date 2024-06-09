package Exp6A;

public class Code7_SumOfDigits {
    private static int sumOfDigits(int num) {
        if (num == 0) {
            return 0;
        }
        return num % 10 + sumOfDigits(num / 10);
    }

    public static void main(String[] args) {
        System.out.println("Prerna Sunil Jadhav - 60004220127\n");

        int result = sumOfDigits(1234);
        System.out.println(result);
    }
}
