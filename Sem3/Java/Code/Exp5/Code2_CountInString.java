package Exp5;

import java.util.Scanner;

public class Code2_CountInString {
    public static void main(String[] args) {
        System.out.println("Prerna Sunil Jadhav - 60004220127");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String str = sc.nextLine();
        countCharacterType(str);
        sc.close();
    }
    static void countCharacterType(String str)
    {
        int vowels = 0, consonant = 0, specialChar = 0, digit = 0, alphabets = 0, blank = 0;
      
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ( (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') ) {
                alphabets++;
                // To handle upper case letters
                ch = Character.toLowerCase(ch);
                if (ch == 'a' || ch == 'e' || ch == 'i' ||
                    ch == 'o' || ch == 'u')
                    vowels++;
                else
                    consonant++;
            }
            else if (ch >= '0' && ch <= '9')
                digit++;
            else if (ch == ' ' || ch == '\t')
                blank++;
            else
                specialChar++;
        }
          
        System.out.println("Alphabets: " + alphabets);
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonant: " + consonant);
        System.out.println("Digit: " + digit);
        System.out.println("Blank Spaces: " + blank);
        System.out.println("Special Character: " + specialChar);
    }
}
