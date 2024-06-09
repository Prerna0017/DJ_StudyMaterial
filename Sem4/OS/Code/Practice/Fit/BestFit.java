package Practice.Fit;

public class BestFit {
    static void best(int blocks[], int process[]){
        int allocation[] = new int[process.length];
        for (int i = 0; i<process.length; i++){
            int bestIndex = -1;
            for (int j = 0; j<blocks.length; j++){
                if (blocks[j] >= process[i]){
                    if(bestIndex == -1){
                        bestIndex = j;
                    }                    
                    else if(blocks[bestIndex] > blocks[j]){
                        bestIndex = j;
                    }
                    
                }
            }
            if (bestIndex!=-1){
                allocation[i] = bestIndex;
				blocks[bestIndex] -= process[i];
            }
        }

        System.out.println("\nProcess No.\tProcess Size\tBlock no.");
		for (int i = 0; i < process.length; i++)
		{
			System.out.print(" " + (i+1) + "\t\t" + process[i] + "\t\t");
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
		
		best(blockSize, processSize);
    }
}
