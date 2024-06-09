package Exp2;
import java.util.Scanner;
public class Code2_SwitchCase {
    public static void main(String[] args) {
        System.out.println("Prerna Jadhav - 60004220127");
        int operator;
        Double number1, number2;
        Scanner input = new Scanner(System.in); // create an object of Scanner class
        System.out.println("********MENU********\n1.Addition\n2.Subtraction\n3.Multiplication\n4.Division\n5.Exit\n");
        System.out.print("Enter your Choice: ");
        operator = input.nextInt();
        System.out.println("Enter first number");   // ask users to enter numbers
        number1 = input.nextDouble();
        System.out.println("Enter second number");
        number2 = input.nextDouble();
        switch (operator) {
            case 1:     // performs addition between numbers
                System.out.println(number1 + " + " + number2 + " = " + (number1 + number2));
                break;
            case 2:     // performs subtraction between numbers
                System.out.println(number1 + " - " + number2 + " = " + (number1 - number2));
                break;
            case 3:     // performs multiplication between numbers
                System.out.println(number1 + " * " + number2 + " = " + (number1 * number2));
                break;
            case 4:     // performs division between numbers
                System.out.println(number1 + " / " + number2 + " = " + (number1 / number2));
                break;
            case 5:     //To exit Code
                System.exit(0);
            default:    //if invalid choice is entered
                System.out.println("Invalid operator!");
                break;
            }
        input.close();
    }
}
