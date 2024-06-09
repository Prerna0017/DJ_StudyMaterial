package Practice;

import java.util.Scanner;

public class Producer_Consumer {
    static int Mutex = 1;       //1->critical section is empty
    static int n = 3;
    static int empty_slot = n;
    static int full_slot = 0;
    static int item = 0;
    public static void main(String[] args) {
        int choice = 0;
        Scanner sc  = new Scanner(System.in);
        while(true){
            System.out.println("1. Producer\n2. Consumer\n3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    //producer
                    if (Mutex == 1 && empty_slot != 0){
                        Mutex--;    //wait (decrement mutex) 0-->critical section occupied
                        empty_slot--;
                        full_slot++;    //signal
                        item++;
                        System.out.println("Producer produced: "+item);
                        Mutex++;

                    }
                    else{
                        System.out.println("No more space");
                    }
                    break;

                case 2:
                    //consumer
                    if (Mutex == 1 && full_slot != 0){
                        Mutex--;    //wait (decrement mutex) 0-->critical section occupied
                        full_slot--;    //signal
                        empty_slot++;
                        System.out.println("Consumer consumed: "+item);
                        item--;
                        Mutex++;

                    }
                    else{
                        System.out.println("No item present");
                    }
                    break;

                case 3:
                    System.out.println("Shutting down");
                    sc.close();
                    return;

                default:
                    System.out.println("You entered a wrong choice");
                    break;
            }

        }
    }
}
