import java.util.Scanner;

public class StudentDescMarks {
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

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void display(Student[] arr2) {
        int arr[] = new int[arr2.length];
        for(int i = 0; i<arr.length; i++){
            arr[i] = arr2[i].total;
        }

        for(int i = 0;i<arr.length;i++){
            for(int j=i+1; j<arr.length; j++){
                if (i<j){
                    swap (arr,i,j);
                }
            }
        }

        for (int i : arr) {
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

