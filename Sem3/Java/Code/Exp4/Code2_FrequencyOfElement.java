package Exp4;
import java.util.*;
public class Code2_FrequencyOfElement {
    public static void main(String[] args) {
        System.out.println("Prerna Sunil Jadhav - 60004220127");
        Vector<Integer> v = new Vector<>();
        v.add(23);
        v.add(89);
        v.add(23);
        v.add(45);
        v.add(23);
        v.add(89);
        System.out.println("Vector: "+v.toString());
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < v.size(); i++){  // Traverse through array elements and count frequencies{
           if (mp.containsKey(v.get(i))){
             mp.put(v.get(i), mp.get(v.get(i)) + 1);
           }
           else{
             mp.put(v.get(i), 1);
           }
       }
       for (Map.Entry<Integer, Integer> entry : mp.entrySet()){ // Traverse through map and print frequencies
            System.out.println(entry.getKey() + " occurs " + entry.getValue()+" times ");
       }
    }
}
