import java.util.Scanner;

//2.	WAP to display odd numbers from given range/ prime numbers from given range
public class OddNPrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the range:");
        System.out.print("Enter start: ");
        int start = sc.nextInt();
        System.out.print("Enter end: ");
        int end = sc.nextInt();

        odd(start, end);
        prime(start, end);

        sc.close();
    }

    private static void prime(int start, int end) {
        System.out.println("\nPrime Numbers "+start+" - "+end);
        int flag=0;
        for (int i = start; i<=end; i++){
            flag=0;
            if (i == 0 || i == 1){
                continue;
            }
            if (i == 2){
                System.out.print(i+"\t");
                continue;
            }
            for (int j = 2; j<=i/2; j++){
                if (i%j ==0){
                    flag+=1;
                }
            }
            if (flag == 0)
                System.out.print(i+"\t");
        }
    }

    private static void odd(int start, int end) {
        System.out.println("\nODD Numbers "+start+" - "+end);
        for (int i = start; i<=end; i++){
            if (i % 2 != 0){
                System.out.print(i+"\t");
            }
        }
        System.out.println();
    }
}
