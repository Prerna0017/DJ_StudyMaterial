package Exp6B;
import java.util.Scanner;
public class Code1_Student {
    public static void main(String[] args) {
        System.out.println("Prerna Sunil Jadhav - 60004220127\n");
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the number of Students: ");
        int n = sc.nextInt();
        Student[] studArray = new Student[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Details of Student " + (i + 1));
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            System.out.print("Enter name: ");
            String name = sc.next();
            System.out.print("Enter Maths Marks: ");
            int maths = sc.nextInt();
            System.out.print("Enter Physics Marks: ");
            int phy = sc.nextInt();
            System.out.print("Enter Chemistry Marks: ");
            int chem = sc.nextInt();
            studArray[i] = new Student(id, maths, phy, chem, name);
        }
        System.out.println("Marks in descending order:");
        display(studArray);
        sc.close();
    }
    public static void display(Student[] arr2) {
        int arr[] = new int[arr2.length];
        for(int i = 0; i<arr.length; i++){
            arr[i] = arr2[i].total;
        }
        for(int i = 1;i < arr2.length; i++) {
            int j = i;
            while(j > 0 && arr[j] < arr[j-1]) {
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
        int[] b = new int[arr2.length];
        int j = arr2.length;
        for (int i = 0; i < arr2.length; i++) {
            b[j - 1] = arr[i];
            j = j - 1;
        }
  
        for (int i: b) {
            for (Student s: arr2){
                if (s.total == i){
                    System.out.println(s.name+" "+i);
                }
            }
        }
    }
}

class Student {
    int total, id, maths, physics, chemistry;
    String name;

    Student(int id, int maths, int phy, int chem, String name) {
        this.id = id;
        this.maths = maths;
        this.physics = phy;
        this.chemistry = chem;
        this.name = name;
        this.total = this.id + this.maths + this.physics + this.chemistry;
    }
}
