import java.util.Scanner;       //importing Scanner class

public class Code2_CountDigits {
    public static void main(String[] args) {
        System.out.println("Prerna Jadhav - 60004220127\n");

        Scanner sc = new Scanner(System.in);    //Creating Scanner object to take input
        System.out.print("Enter any Number: ");
        int num = sc.nextInt();                 //taking input from user
        int temp = num;
        int count = 0;
        while (num!=0){                         //looping until num becomes 0
            count++;
            num /= 10;
        }
        System.out.println("Count of "+temp+" is "+count);   //displaying sum
        sc.close();                             //closing the scanner
    }   
}
