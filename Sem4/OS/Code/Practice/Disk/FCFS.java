package Practice.Disk;

public class FCFS {
    public static void main(String[] args) {
        int arr[] = {82, 170, 43, 140, 24, 16,190};
        int track = 200;
        int head = 50;
        int seek_time = FCFS_Disk(arr, track, head);
        System.out.println("Seek Time: "+seek_time);
    }

    static int FCFS_Disk(int arr[], int track, int head){
        int seek_time = Math.abs(arr[0] - head);


        for (int i = 1; i<arr.length; i++){
            seek_time += Math.abs(arr[i] - arr[i-1]);
        }

        return seek_time;
    }
}
