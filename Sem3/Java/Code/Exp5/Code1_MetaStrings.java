package Exp5;
import java.util.Arrays;
public class Code1_MetaStrings {
    public static void main(String[] args) {
        System.out.println("Prerna Sunil Jadhav");
        String str1 = "converse";
        String str2 = "converse";
        if(areAlmostEqual(str1,str2)){
            System.out.println("They are Meta Strings");
        }else{
            System.out.println("They are not Meta Strings");
        }
    }
    static boolean areAlmostEqual(String s1, String s2) {
        int[] s1Array = new int[26];
        int[] s2Array = new int[26];
        int counter = 0;
        for(int i = 0;i<s1.length();i++){
           char s = s1.charAt(i);
           char ss = s2.charAt(i);
           if(s != ss)
              counter++;
           if(counter > 2)
              return false;
            s1Array[s -'a']++;
           s2Array[ss -'a']++;
        }
        return Arrays.equals(s1Array, s2Array);
    }
}
/****
- find two mismatches, if mismatches more than 2 return false
- record mismatch indexes. 
  - If no mismatch then a = -1;
  - Else if only one mismtahc, then return false ==> one char diff can not lead to swap

****/
