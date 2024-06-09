import java.util.Scanner;

public class ByteStuffing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n; 
        System.out.println("Enter the number of frames:\t"); 
        n = sc.nextInt();
        
        char[][] data = new char[n][20];
 
        for (int i = 0; i < n; i++) { 
            System.out.print("\nEnter frame "+(i+1)+" data\t"); 
            data[i][0] = sc.next().charAt(0);
        } 
 
        System.out.print("\nData sent from the sender's side is:\t"); 
        
        for(int i=0 ; i<n ;i++){ 
            System.out.print("$"); 

            for (int j = 0; j < data[i].length; j++) { 
                if(data[i][j] == '$' || data[i][j] == '#'){ 
                    System.out.print("#"); 
                } 
                System.out.print(data[i][j]); 
            } 

            System.out.print("$"); 
        } 

        sc.close();
    }
}
