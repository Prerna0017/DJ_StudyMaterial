package Exp2;

public class Code5b_Pattern2 {
    public static void main(String[] args) {
        System.out.println("Prerna Sunil Jadhav - 60004220127");
        int n=4;
        char A = 64;
        for (int i = 0; i<n; i++){
            //spaces
            for (int s = n-(i+1); s>0; s--){
                System.out.print("\t");
            }

            A+=(i+1);
            char temp = A;
            for(int j = i+1; j>=1; j--){
                System.out.print(temp+"\t");
                temp-=1;
            }
            System.out.println();
        }
    }
}
