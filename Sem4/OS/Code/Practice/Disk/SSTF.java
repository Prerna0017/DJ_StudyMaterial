package Practice.Disk;

public class SSTF {
    public static void main(String[] args) {
        int arr[] = { 82, 170, 43, 140, 24, 16, 190 };
        int track = 200;
        int head = 50;
        int seek_time = SSTF_Disk(arr, track, head);
        System.out.println("Seek Time: " + seek_time);
    }

    static int SSTF_Disk(int arr[], int track, int head) {
        int seek_time = 0;
        
        for (int i = 0; i < arr.length; i++) {

            int nearest_track_distance = 10000;
            int nearest_track_distance_index = -1;

            for (int j = 0; j < arr.length; j++) {
                if ((Math.abs(head - arr[j])) < nearest_track_distance) {
                    nearest_track_distance = Math.abs(head - arr[j]);
                    nearest_track_distance_index = j;
                }
            }
            
            seek_time += Math.abs(arr[nearest_track_distance_index] - head);
            head = arr[nearest_track_distance_index];
            arr[nearest_track_distance_index] = 100000;
        }

        return seek_time;
    }
}
