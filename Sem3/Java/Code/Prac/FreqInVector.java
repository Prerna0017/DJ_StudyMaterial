import java.util.Arrays;
import java.util.Vector;

public class FreqInVector {
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<Integer>(10, 5);
        v.add(23);
        v.add(2);
        v.add(3);
        v.add(123);
        v.add(67);
        v.add(2);
        v.add(3);
        v.add(23);
        boolean visited[] = new boolean[v.size()];
     
        Arrays.fill(visited, false);
        for (int i = 0; i < v.size(); i++) {
            // Skip this element if already processed
            if (visited[i] == true)
                continue;

            // Count frequency
            int count = 1;
            for (int j = i + 1; j < v.size(); j++) {
                if (v.get(i) == v.get(j)) {
                    visited[j] = true;
                    count++;
                }
            }
            System.out.println(v.get(i) + " " + count);
        }
    }
}
