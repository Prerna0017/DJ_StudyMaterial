//1.	Write a Java program that reads a positive integer from command line and count the number of digits the number (less than ten billion) has.
public class countDigitCmd {
    public static void main(String[] args) {
        int num = Integer.parseInt(args[0]);
        int count = 0;
        while (num!=0){
            count++;
            num/=10;
        }
        System.out.println("Count: "+count);
    }
}
 