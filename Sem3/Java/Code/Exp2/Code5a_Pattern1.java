package Exp2;
public class Code5a_Pattern1 {
    public static void main(String[] args) {
        System.out.println("Prerna Sunil Jadhav - 60004220127");
        int n = 7;
        for (int i = 1; i<=n; i++){
            if (i%2==0){    //if is even row then reverse
                for (int j = i; j>=1; j--){
                    System.out.print(j + "\t");
                }
            }
            else{
                for (int j = 1; j<=i; j++){
                    System.out.print(j + "\t");
                }
            }
            System.out.println();
        }
    }
}
