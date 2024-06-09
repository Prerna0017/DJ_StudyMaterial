package Practice.Disk;

import java.util.Arrays;
import java.util.Collections;

public class C_SCAN {
    public static void main(String[] args) {
        int arr[] = { 82, 170, 43, 140, 24, 16, 190 };
        int track = 200;
        int head = 50;
        String direction = "right";
        int seek_time = C_SCAN_Disk(arr, track, head, direction);
        System.out.println("Seek Time: " + seek_time);
    }

    static int C_SCAN_Disk(int arr[], int track, int head, String direction) {
        int seek_time = 0;
        int right[] = new int[arr.length];
        int left[] = new int[arr.length];
        int j=0;

        if (direction.equals("right")){
            for (int i = 0; i<arr.length; i++){
                if (arr[i]>head){
                    right[j] = arr[i];
                    j++;
                }
            }
            j=0;
            int max = -1;
            for (int i = 0; i<arr.length; i++){
                if (arr[i]<head ){
                    if (arr[i]>max){
                        max = arr[i];
                    }
                    left[j] = arr[i];
                    j++;
                }
            }
            seek_time += (track-1) - head;
            seek_time += (track-1) - 0; //going to 0 without picking values 
            seek_time += max - 0;
            
            System.out.println(head);
            for (int k = 0; k<right.length; k++){
                if (right[k] == 0){
                    continue;
                }
                System.out.println(right[k]);
            }
            System.out.println(track-1);
            System.out.println("0");
            for (int k = left.length-1; k>=0; k--){
                if (left[k] == 0){
                    continue;
                }
                System.out.println(left[k]);
            }
        }
        else{
            seek_time += head;
            seek_time += maximumRequest(arr);
            for (int i = 0; i<arr.length; i++){
                if (arr[i]>head){
                    right[j] = arr[i];
                    j++;
                }
            }
            j=0;
            for (int i = 0; i<arr.length; i++){
                if (arr[i]<head){
                    left[j] = arr[i];
                    j++;
                }
            }
            System.out.println(head);
            for (int k = left.length-1; k>=0; k--){
                if (left[k] == 0){
                    continue;
                }
                System.out.println(left[k]);
            }
            for (int k = 0; k<right.length; k++){
                if (right[k] == 0){
                    continue;
                }
                System.out.println(right[k]);
            }

        }
        return seek_time;
    }

    static int minimumRequest(int[] arr){
        Arrays.sort(arr);
        return arr[0];
    }

    static int maximumRequest(int[] arr){
        // Collections.sort(arr, Collections.reverseOrder());
        
        Arrays.sort(arr);
        Collections.reverseOrder();
        return arr[arr.length-1];
    }
}
