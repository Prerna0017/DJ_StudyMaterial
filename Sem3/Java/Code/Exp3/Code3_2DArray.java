package Exp3;
import java.util.Scanner;
public class Code3_2DArray {
    public static void main(String[] args) {
        System.out.println("Prerna Sunil Jadhav - 60004220127");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of Students: ");
        int row = sc.nextInt();
        System.out.print("Enter Number of Subjects: ");
        int col = sc.nextInt();
        int student[][] = new int[row][col];
        for (int i = 0; i<row; i++){
            System.out.println("Enter Marks for Student "+(i+1)+" :");
            for (int j = 0; j<col; j++){
                System.out.print("Enter Marks for Subject "+(j+1)+" : ");
                student[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i<row; i++){
            int sum = 0;
            for (int j = 0; j<col; j++){
                System.out.print(student[i][j]+"\t");
                sum += student[i][j];}
            System.out.println(" | "+sum);
        }
        System.out.println("-----------------------------");
        int total =0;
        for (int i = 0; i<col; i++){
            int sum=0;
            for(int j = 0; j<row; j++)
                sum += student[j][i];
            System.out.print(sum + "\t");
            total += sum;
        }
        System.out.println(" | "+total);
        sc.close();




    }
}
