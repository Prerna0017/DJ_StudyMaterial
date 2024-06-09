package Practice;

import java.util.Arrays;

public class Bankers {
    public static void main(String[] args) {
        int process[] = {1,2,3,4,5};

        int allocation[][] = {
            {0,1,0},
            {2,0,0},
            {3,0,2},
            {2,1,1},
            {0,0,2}
        };

        int max_need[][] = {
            {7,5,3},
            {3,2,2},
            {9,0,2},
            {4,2,2},
            {5,3,3},
        };

        int total[] = {10, 5, 7};

        int available[] = new int [3];

        int sum0 =0, sum1=0, sum2=0;
        for (int i = 0; i<process.length;i++){
            sum0 += allocation[i][0];
            sum1 += allocation[i][1];
            sum2 += allocation[i][2];
        }

        available[0] = total[0] - sum0;
        available[1] = total[1] - sum1;
        available[2] = total[2] - sum2;

        System.out.println(Arrays.toString(available));

        isSafe (allocation, max_need, available, process);
    }

    private static boolean isSafe(int[][] allocation, int[][] max_need, int[] available, int[] process) {
        int P = process.length;
        int remaining_need[][] = new int[5][3];

        for (int i = 0; i<process.length; i++){
            for (int j = 0; j<3; j++){
                remaining_need[i][j] = max_need[i][j] - allocation[i][j];
            }
        }
        
        boolean[] finished_processes = new boolean[P];

        int[] safeSequence = new int [P];

        int count = 0;
        while (count<P){
            boolean found = false;

            for (int proc = 0; proc<P; proc++){
                if (finished_processes[proc] == false){
                    int j;
                    for (j = 0; j<3; j++){
                        if (remaining_need[proc][j]>available[j]){
                            break;
                        }
                    }

                    if (j==3){
                        for (int k = 0; k<3; k++){
                            available[k] += allocation[proc][k];
                        }
                        safeSequence[count++] = proc;
                        finished_processes[proc] = true;
                        found = true;
                    }
                }
            }

            if (found == false){
                System.out.println("DEADLOCK");
                return false;
            } 
        }

        System.out.println("All the processes can be executed with no DEADLOCK!");
        System.out.print("Sequence is -> ");
                                               
        for (int processes = 0; processes<P; processes++){
            System.out.print("P"+safeSequence[processes]+"\t");
        }

        return true;
    }
}
