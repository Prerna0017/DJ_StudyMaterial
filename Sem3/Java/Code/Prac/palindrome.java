import java.util.Scanner;

public class palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder s = new StringBuilder(str);

        if (str.equalsIgnoreCase((s.reverse()).toString())){
            System.out.println("Equal");
            
        }
        else{
            System.out.println("Not Equal");
        }

        String new2="";
        for (int i = str.length()-1; i>=0; i--){
            char ch = str.charAt(i);
            new2+=ch;
        }
        System.out.println(new2);
        if (new2.equals(str)){
            System.out.println("Equal");
        }
        else{
            System.out.println("Not equal");
        }

        sc.close();
    }
}
