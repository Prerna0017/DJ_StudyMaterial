public class Bankers {

    static int P = 5;
    static int R = 3;
    
    public static void main(String[] args) {
        
        int process[] = {0, 1, 2, 3, 4};

        int available_resources[] = {3, 3, 2};

        int maximum_need_resources[][] = {{7, 5, 3},
                                    {3, 2, 2},
                                    {9, 0, 2},
                                    {2, 2, 2},
                                    {4, 3, 3}};

        int alloted_resources[][] = {{0, 1, 0},
                                    {2, 0, 0},
                                    {3, 0, 2},
                                    {2, 1, 1},
                                    {0, 0, 2}};

        isSafe(process, available_resources, maximum_need_resources, alloted_resources);
    }

    private static boolean isSafe(int[] process, int[] available_resources, int[][] maximum_need_resources, int[][] alloted_resources) {

        int[][] need_of_resources = new int[P][R];

        calculateCurrentNeedOfResources(maximum_need_resources, alloted_resources, need_of_resources);

        boolean[] finished_processes = new boolean[P];

        int[] safeSequence = new int [P];

        int[] current_status_of_resources = new int[R];
        for (int i = 0; i<R; i++){
            current_status_of_resources[i] = available_resources[i];
        }

        int count = 0;
        while (count < P){
            boolean found = false;

            for (int proc = 0; proc<P; proc++){

                if (finished_processes[proc] == false){
                    int j;
                    for (j=0; j<R; j++){
                        if (need_of_resources[proc][j] > current_status_of_resources[j]){
                            break;  //we dont have sufficient resource instances
                        }
                    }

                    if (j == R){
                        for (int k = 0; k<R; k++){
                            current_status_of_resources[k] += alloted_resources[proc][k];
                        }
                        safeSequence[count++] = proc;
                        finished_processes[proc] = true;
                        found = true;
                    }
                }
            }

            if (found == false){
                System.out.println("System encontering DEADLOCK!!");
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

    private static void calculateCurrentNeedOfResources(int[][] maximum_need_resources, int[][] alloted_resources, int[][] need_of_resources) {

        for (int i = 0; i<P; i++){
            for (int j = 0; j<R; j++){
                need_of_resources[i][j] = maximum_need_resources[i][j] - alloted_resources[i][j];
            }
        }

    }    
}
