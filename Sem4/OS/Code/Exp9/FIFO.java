package Exp9;

public class FIFO{
    public static void main(String args[]){
        int referenceString[] = {3, 1, 2, 1, 6, 5, 1, 3};
        int pageFrame[] = {-1, -1, -1};

        int pageFaults = FIFO_algo(referenceString, pageFrame);

        int pageHits = referenceString.length - pageFaults;

        System.out.println("Page Hits: "+pageHits);
        System.out.println("Page Faults: "+pageFaults);
        System.out.println("Page Hit Ratio: "+(pageHits/referenceString.length));
        System.out.println("Page Fault Ratio: "+(pageFaults/referenceString.length));
    }

    private static int FIFO_algo(int referenceString[], int frames[]){
        int pageFaults = 0;
        int pointer = 0;
        for (int page = 0; page<referenceString.length; page++){
            
            boolean isPagePresent = false;
            for (int frame = 0; frame<frames.length; frame++){
                if (referenceString[page] == frames[frame]){
                    isPagePresent = true;
                }
            }
            if (!isPagePresent){
                pageFaults++;
                frames[pointer] = referenceString[page];
                pointer++;
            }
            if (pointer==frames.length){
                pointer=0;
            }

            System.out.print(referenceString[page]+"\t\t\t | ");
            for (int i = 0;i<frames.length; i++){
                System.out.print(frames[i]+"\t | ");
            }
            System.out.println();
        }
        return pageFaults;
    }
}
