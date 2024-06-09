package Exp6A;

public class Code6_AddNumbers {

    public static void main(String[] args) {
        System.out.println("Prerna Sunil Jadhav - 60004220127\n");

        int number = 250;
        int sum = addNumbers(number);
        System.out.println("Sum of first " + number + " numbers = " + sum);
    }

    public static int addNumbers(int num) {
        if (num != 0)
            return num + addNumbers(num - 1);
        else
            return num;
    }
}
