package Practice.Page_Replacement;

public class LRU_Page {
    public static void main(String[] args) {
        int referenceString[] = {2, 3, 5, 4, 2, 5, 7, 3, 8, 7};
        int frames[] = {-1,-1,-1};
        int pageFaults = LRU(referenceString, frames);

        int pageHits = referenceString.length - pageFaults;

        System.out.println("Page Hits: "+pageHits);
        System.out.println("Page Faults: "+pageFaults);

        float hitRatio = (float)pageHits/referenceString.length;
        System.out.printf("Page Hit Ratio: %.2f\n",hitRatio);
        float faultRatio = (float)pageFaults/referenceString.length;
        System.out.printf("Page Fault Ratio: %.2f",faultRatio);
    }

    private static int LRU(int[] referenceString, int[] frames) {
        int pageFaults = 0;

        for (int i = 0; i<referenceString.length; i++){
            boolean pagePresent = false;

            for (int j = 0; j<frames.length; j++){
                if (frames[j] == referenceString[i]){
                    pagePresent = true;
                }
            }

            if (pagePresent == false){
                pageFaults++;
                // System.out.println("page fault");
                for (int page = 0; page<frames.length-1; page++){
                    frames[page] = frames[page+1];
                }
                frames[frames.length-1] = referenceString[i];
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
