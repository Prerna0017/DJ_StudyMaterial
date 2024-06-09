package Exp6A;

class Code5_Reverse {
    public static void Reverse(int num)
    {
        if (num < 10) {
            System.out.println(num);
            return;
        }
        else {
            System.out.print(num % 10);
            Reverse(num / 10);
        }
    }
 
    public static void main(String args[])
    {
        System.out.println("Prerna Sunil Jadhav - 60004220127\n");
        int num = 870341009;
        System.out.print("Reversed Number: ");
        Reverse(num);
    }
}
