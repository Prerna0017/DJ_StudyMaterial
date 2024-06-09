import java.util.Scanner;

public class SortDesc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size: ");
        int size = sc.nextInt();
        int arr[] = new int[size];

        for (int i=0; i<arr.length; i++) {
            System.out.print("Enter Element "+(i+1)+": ");
            arr[i] = sc.nextInt();
        }

        for(int i = 0;i<arr.length;i++){
            for(int j=i+1; j<arr.length; j++){
                if (i<j){
                    swap (arr,i,j);
                }
            }
        }

        for (int i : arr) {
            System.out.println(i);
        }

        sc.close();
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        
    }
}
