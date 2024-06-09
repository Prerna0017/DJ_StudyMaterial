public class BitStuffing {
    public static void main(String[] args) {
        String data = "1011111111111111";

        sender(data);
        
    }

    private static void sender(String data) {
        int count = 0;
        int n = data.length();
        int i = 0;
        while (i<n){
            if (data.charAt(i) == '0'){
                for (int j = 1; j<= 6; j++){
                    i++;
                    if (data.charAt(i)=='1'){
                        count+=1;
                        if (count==6){
                            break;
                        }
                    }
                    else{
                        count = 0;
                        break;
                    }
                }

                if (count == 6){
                    StringBuffer stringBuffer = new StringBuffer(data);
                    stringBuffer.insert(i, 0);
                    data = stringBuffer.toString();
                    count = 0;
                }
            }
            i++;
        }

        System.out.println(data);
    }
}
