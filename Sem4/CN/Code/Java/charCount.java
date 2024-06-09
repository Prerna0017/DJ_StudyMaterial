import java.util.Scanner;

class charCount{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        String data_to_be_transmitted;
        System.out.print("Enter the no. of data units: ");
        n = sc.nextInt();

        data_to_be_transmitted = sender(n);

        System.out.println("Data To Be Transmitted: "+data_to_be_transmitted);

        receiver(data_to_be_transmitted);

        sc.close();
    }
    
    static String sender(int n){
        Scanner sc = new Scanner(System.in);
        String data_to_be_transmitted = "";
        String data_unit;
        
        for (int i = 0; i<n; i++){
            System.out.print("Enter data Unit "+(i+1)+": ");
            data_unit = sc.nextLine();
            
            int length = data_unit.length() + 1;
            
            data_to_be_transmitted = data_to_be_transmitted + (Integer.toString(length)) + data_unit;
        }
        
        sc.close();
        return data_to_be_transmitted;
    }

    static void receiver(String data_to_be_transmitted){
        int j , i = 0;
        
        while (i<data_to_be_transmitted.length()-1){
            
            int length = Character.getNumericValue(data_to_be_transmitted.charAt(i));
            
            System.out.print("Data Unit "+(i+1)+": ");
            for (j = 0; j<length-1; j++){
                i++;
                System.out.print(data_to_be_transmitted.charAt(i));
            }
            System.out.println();

            //need to inc i as after printing data unit we need next length
            if (i<data_to_be_transmitted.length()){
                i++;
            }
        }
    }
}