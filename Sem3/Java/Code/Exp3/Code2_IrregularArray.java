package Exp3;

public class Code2_IrregularArray {
    public static void main(String[] args) {
        System.out.println("Prerna Sunil Jadhav - 60004220127");
        // Declaring 2-D array with 2 rows
        int arr[][] = new int[2][];        
        arr[0] = new int[2];    // First row has 3 columns
        arr[1] = new int[3];    // Second row has 2 columns
        int count = 2;
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                arr[i][j] = count++;                    // Initializing array
        // Displaying the values of 2D Jagged array
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }
}
