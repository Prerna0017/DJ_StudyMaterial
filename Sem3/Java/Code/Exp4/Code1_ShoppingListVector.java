package Exp4;

import java.util.Scanner;
import java.util.Vector;

public class Code1_ShoppingListVector {
    public static void main(String[] args) {
        System.out.println("Prerna Sunil Jadhav - 60004220127");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the No. of Item \n(you can extend it later as it is in Vector: ");
        int initialSize = sc.nextInt();
        // creating a vector of given Capacity = 20 and Increment=10
        // Here vector capacity will increase by 10 when needed
        Vector<String> shoppingList = new Vector<String>(initialSize, 10);
        for(int i = 0; i<initialSize; i++){
            System.out.print("Enter Item "+(i+1)+" : ");
            String item = sc.next();
            shoppingList.add(item);
        }
        int ch = 0;
        while(ch!=4){
            System.out.print("Menu\n1.Add a new item\n2.Delete an item\n3.Show List\n4.Exit\nEnter your choice: ");
            ch = sc.nextInt();
    
            switch(ch){
                case 1:
                    System.out.print("Enter the element to be added: ");
                    String item = sc.next();
                    System.out.print("Enter the position at which it needs to added: ");
                    int index = sc.nextInt();
                    shoppingList.add(index-1, item);
                    System.out.println(item+" added Successfully!! --> "+shoppingList.toString());
                    break;
                case 2:
                    System.out.print("Enter the element to be removed: ");
                    String remove_item = sc.next();
                    shoppingList.remove(remove_item);
                    System.out.println(remove_item+" removed Successfully!! --> "+shoppingList.toString());
                    break;
                case 3:
                    System.out.println(shoppingList.toString());
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
        sc.close();
    }
}
