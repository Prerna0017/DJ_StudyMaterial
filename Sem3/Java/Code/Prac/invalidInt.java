public class invalidInt {
    public static void main(String[] args) {
        try{
            Integer.parseInt(args[0]);
            System.out.println("Integer");
        }catch(NumberFormatException e){
            System.out.println("String");
        }
    }
}
