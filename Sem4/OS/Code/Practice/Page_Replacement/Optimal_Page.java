package Practice.Page_Replacement;

import java.util.Arrays;

public class Optimal_Page {
    public static void main(String[] args) {
        int referenceString[] = {1,2,3,2,1,5,2,1,6,2,5,6,3,1,3,6,1,2,4,3};
        int frames[] = {-1,-1,-1};
        int pageFaults = Optimal(referenceString, frames);

        int pageHits = referenceString.length - pageFaults;

        System.out.println("Page Hits: "+pageHits);
        System.out.println("Page Faults: "+pageFaults);

        float hitRatio = (float)pageHits/referenceString.length;
        System.out.printf("Page Hit Ratio: %.2f\n",hitRatio);
        float faultRatio = (float)pageFaults/referenceString.length;
        System.out.printf("Page Fault Ratio: %.2f",faultRatio);
    }

    private static int Optimal(int[] referenceString, int[] frames) {
        int pageFaults = 0;
        int pointer = 0;
        
        for (int i = 0; i<referenceString.length; i++){
            boolean isPagePresent = false;

            for (int j = 0; j<frames.length; j++){
                if (referenceString[i] == frames[j]){
                    isPagePresent = true;
                }
            }

            //filling initially empty frames
            if (i<frames.length && isPagePresent == false){
                if (pointer == frames.length){
                    pointer=0;
                }
                pageFaults++;
                frames[pointer] = referenceString[i];
                pointer++;
            }

            if (i>frames.length && isPagePresent == false){
                pageFaults++;
                int index = predict(i, referenceString, frames);
                frames[index] = referenceString[i];
            }

            System.out.print(referenceString[i]+"\t\t\t | ");
            for (int page = 0;page<frames.length; page++){
                System.out.print(frames[page]+"\t | ");
            }
            System.out.println();

        }

        return pageFaults;
    }

    private static int predict(int i, int[] referenceString, int[] frames) {
        int index = -1;
        int max = 0;
        int framesOccurence[] = new int[frames.length]; 
        Arrays.fill(framesOccurence, referenceString.length+2);

        for (int j = 0; j<frames.length; j++){
            for (int k = i+1; k<referenceString.length; k++ ){
                if (referenceString[k] == frames[j]){
                    framesOccurence[j] = k;
                    break;
                }
            }
        }

        for (int l = 0; l<framesOccurence.length; l++){
            if (framesOccurence[l] > max){
                max = framesOccurence[l];
                index = l;
            }
        }

        return index;
    }
}
