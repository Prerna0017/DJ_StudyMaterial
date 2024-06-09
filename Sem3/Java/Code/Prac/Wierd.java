import java.util.Scanner;

public class Wierd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n%2 != 0){
            System.out.println("Wierd");
        }
        else{
            if(n>=2 && n<=5){
                System.out.println("Not weird");
            }
            else if(n>=5 && n<=20){
                System.out.println("Weird");
            }
            else if (n>20){
                System.out.println("Weird");
            }
        }
        sc.close();
    }
}
