package Practice.Fit;

public class FirstFit {
    static void first(int blocks[], int process[]) {
        int allocation[] = new int[process.length];

        for (int i = 0; i < process.length; i++) {
            int maxIndex = -1;
            int j = 0;
            while (blocks[j]<process[i]){
                j++;
            }
            maxIndex = j;
            
            if (maxIndex != -1) {
                allocation[i] = maxIndex;
                blocks[maxIndex] -= process[i];
            }
        }

        System.out.println("\nProcess No.\tProcess Size\tBlock no.");
        for (int i = 0; i < process.length; i++) {
            System.out.print(" " + (i + 1) + "\t\t" + process[i] + "\t\t");
            if (allocation[i] != -1)
                System.out.print(allocation[i] + 1);
            else
                System.out.print("Not Allocated");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int blockSize[] = {200, 100, 50, 150, 300};
		int processSize[] = {35, 70, 100,150};
		
		first(blockSize, processSize);
    }
}
