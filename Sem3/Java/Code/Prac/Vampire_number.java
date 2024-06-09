

import java.util.*;
public class Vampire_number {
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int []arr= new int[4];
        int i,j,k,l;
        System.out.println("Enter a 4 digit number");
        int num= sc.nextInt();
        sc.close();

        int temp=num;
        for(i=0;i<4;i++){
            arr[i]=temp%10;
            temp=temp/10;
        }
        for(i=0;i<4;i++){
            for(j=0;j<4;j++){
                if(j!=i){
                    for(k=0;k<4;k++){
                        if(k!=i && k!=j){
                            for(l=0;l<4;l++){
                                if(l!=i && l!=j && l!=k){
                                    if(((10*arr[i]+arr[j])*(10*arr[k]+arr[l])==num)){
                                        System.out.println("It is a vampire number");
                                        System.out.println("Fangs are: "+(10*arr[i]+arr[j])+" and "+((10*arr[k])+arr[l]));
                                        System.exit(0);
                                    }
                                }

                            }
                        }
                    }
                }
            }
        }

        System.out.println("Not a Vampire");




    }
}
