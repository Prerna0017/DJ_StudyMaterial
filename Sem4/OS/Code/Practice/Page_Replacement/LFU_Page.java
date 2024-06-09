package Practice.Page_Replacement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LFU_Page {
    public static void main(String[] args) {
        int referenceString[] = { 1, 2, 3, 4, 2, 1, 5 };
        int frames[] = {-1,-1,-1};
        
        int pageFaults = LFU(referenceString.length, frames.length, referenceString);
        int pageHits = referenceString.length - pageFaults;

        System.out.println("Page Hits: "+pageHits);
        System.out.println("Page Faults: "+pageFaults);

        float hitRatio = (float)pageHits/referenceString.length;
        System.out.printf("Page Hit Ratio: %.2f\n",hitRatio);
        float faultRatio = (float)pageFaults/referenceString.length;
        System.out.printf("Page Fault Ratio: %.2f",faultRatio);
    }

    static int LFU(int n, int c, int[] referenceString)
    {
        int count = 0;                                          //page fault
        List<Integer> v = new ArrayList<Integer>();             //frames
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();     // To store frequency of referenceString
        for (int i = 0; i < n ; i++) {
            int idx = v.indexOf(referenceString[i]);                      // Find if element is present in memory or not
            if (idx == -1) {                                    // If element is not present
                if (v.size() == c) {                            // If memory is full
                    int leastFreqPage = v.get(0);         
                    mp.put(leastFreqPage, mp.get(leastFreqPage) - 1);// Decrease the frequency
                    v.remove(0);                          // Remove the first element as It is least frequently used
                }
                v.add(referenceString[i]);                                // Add the element at the end of memory
                mp.put(referenceString[i], mp.getOrDefault(referenceString[i], 0) + 1);// Increase its frequency
                count++;                                        // Increment the count
            }
            else {
                int page = v.remove(idx);                       // If element is present Remove the element And add it at the end Increase its frequency
                v.add(page);
                mp.put(page, mp.get(page) + 1);
            }
            int k = v.size() - 2;                               // Compare frequency with other referenceString starting from the 2nd last page
            while (k >= 0 && mp.get(v.get(k)) > mp.get(v.get(k + 1))) { // Sort the referenceString based on their frequency And time at which they arrive if frequency is same then, the page arriving first must be placed first
                Collections.swap(v, k, k + 1);
                k--;
            }            
        }
        return count;           // Return total page faults
    }
}
