package Exp11;
public class args{
    public static void main(String[] args){
         try {
            System.out.println("Prerna Sunil Jadhav - 60004220127\n");
            for (int i = 0; i < args.length; i++) {
                int number = Integer.parseInt(args[i]);
                System.out.println("You entered: "+number);   
            }
        }
        catch (NumberFormatException e) {
            System.out.println("NumberFormatException occurred");
        }
    }
}









