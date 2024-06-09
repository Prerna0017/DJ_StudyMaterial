import java.util.Scanner;

public class Pattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        pattern1(row);
        pattern2(row);
        pattern3(row);
        sc.close();
    }

    private static void pattern1(int row) {
        // *
        // * *
        // * * * 
        // * * * * 
        // * * * * *
        for (int i = 0; i<row; i++){
            for (int j = 0; j<=i; j++){
                System.out.print("*\t");
            }
            System.out.println();
        }
    }

    private static void pattern2(int row) {
        //         *
        //       * *
        //     * * * 
        //   * * * * 
        // * * * * *
        int j=0;
        for (int i = 0; i<=row; i++){
            for (j=0; j<row-i; j++){
                System.out.print(" ");
            }
            for(j=0; j<i+1; j++){
                System.out.print("*");
            }
            System.out.println();
        }


    }

    private static void pattern3(int row) {
        int j=0;
        for (int i = 0; i<=row; i++){
            for (j=0; j<row-i; j++){
                System.out.print(" ");
            }
            for(j=0; j<i+1; j++){
                System.out.print("*");
            }
            for (j = 1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
