package Practice.Page_Replacement;

public class FIFO_Page {
    public static void main(String[] args) {
        int referenceString[] = {2,6,7,2,9,4,9,6};
        int frames[] = {-1,-1,-1};
        int pageFaults = FIFO(referenceString, frames);

        int pageHits = referenceString.length - pageFaults;

        System.out.println("Page Hits: "+pageHits);
        System.out.println("Page Faults: "+pageFaults);

        float hitRatio = (float)pageHits/referenceString.length;
        System.out.printf("Page Hit Ratio: %.2f\n",hitRatio);
        float faultRatio = (float)pageFaults/referenceString.length;
        System.out.printf("Page Fault Ratio: %.2f",faultRatio);
    }

    private static int FIFO(int[] referenceString, int[] frames) {
        int pageFaults = 0;
        int pointer = 0;
        
        for (int i = 0; i<referenceString.length; i++){
            boolean pagePresent = false;

            for (int j = 0; j<frames.length; j++){
                if (referenceString[i] == frames[j]){
                    pagePresent = true;
                }
            }

            if (pagePresent == false){
                pageFaults++;
                frames[pointer] = referenceString[i];
                pointer++;
            }

            if (pointer == frames.length){
                pointer=0;
            }

            System.out.print(referenceString[i]+"\t\t\t | ");
            for (int page = 0;page<frames.length; page++){
                System.out.print(frames[page]+"\t | ");
            }
            System.out.println();

        }

        return pageFaults;
    }
}
