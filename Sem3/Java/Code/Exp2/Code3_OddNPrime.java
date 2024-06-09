package Exp2;
import java.util.Scanner;
public class Code3_OddNPrime {
    public static void main(String[] args) {
        System.out.println("Prerna Sunil Jadhav - 60004220127");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a range: ");
        int range = sc.nextInt();
        System.out.print("1.Odd numbers\n2.Prime numbers\nwhat do want to see?: ");
        int operation = sc.nextInt();
        switch(operation){
            case 1:
                OddNumbers(range);
                break;
            case 2:
                PrimeNumbers(range);
                break;
            default:
                System.out.println("Invalid Choice");
        }
        sc.close();
    }
    private static void OddNumbers(int range) {
        System.out.print("Odd Numbers between 1 to "+range+" are ");
        for (int i = 0; i<=range; i++){
            if (i%2!=0)
                System.out.print(i + " , ");
        }
    }
    private static void PrimeNumbers(int range) {
        System.out.print("Prime Numbers between 1 to "+range+" are ");
        for (int i = 2; i<=range; i++){
            if (i == 1 || i == 0)
                continue;
            int flag = 1;
            for(int j = 2; j<=i/2; j++){
                if (i%j==0){
                    flag=0;
                    break;
                }
            }
            if(flag==1)
                System.out.print(i + " , ");
        }
    }
}
