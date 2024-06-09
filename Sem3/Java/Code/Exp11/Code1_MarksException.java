// package Exp11;
// import java.util.*;

// class MarksOutOfBoundException extends Exception {
//     MarksOutOfBoundException(String err) {
//         System.out.println(err);
//     }
// }

// public class Code1_MarksException {
//     public static void main(String args[]) {
//         System.out.println("Prerna Jadhav - 60004220127\n");
//         Scanner input = new Scanner(System.in);
//         int choice = 1;
//         while (choice == 1) {
//             try {
//                 // int m, m2, m3, seatNo, centerNum;
//                 // String name, date;
//                 System.out.println("Enter the Seat Number : ");
//                 int seatNo = input.nextInt();
//                 // String str1 = input.nextLine();
//                 System.out.println("Enter Name of Student : ");
//                 String name = input.nextLine();
//                 System.out.println("Enter the Center Number : ");
//                 int centerNum = input.nextInt();
//                 String str = input.nextLine();
//                 System.out.println("Enter Date : ");
//                 String date = input.nextLine();
//                 System.out.println("Enter the Marks in Maths : ");
//                 int m = input.nextInt();
//                 System.out.println("Enter the Marks in Chemistry : ");
//                 int m2 = input.nextInt();
//                 System.out.println("Enter the Marks in Physics : ");
//                 int m3 = input.nextInt();
//             } catch (Exception e) {
//                 System.out.println(e);
//             }
//             System.out.println("\nEnter your choice : \n1.Enter more Student data \n2.Exit ");
//             choice = input.nextInt();
//         }
//         input.close();
//     }
//     public static void main(int seatNo, int centerNo, String date, String name, int marks, int marks2, int marks3)
//             throws MarksOutOfBoundException {
//         if (marks >= 100 || marks <= 0) {
//             throw new MarksOutOfBoundException(
//                     "Input marks of all subjects should be greater than 0 and less than 100");
//         } else if (marks2 >= 100 || marks2 <= 0) {
//             throw new MarksOutOfBoundException(
//                     "Input marks of all subjects should be greater than 0 and less than 100");
//         } else if (marks3 >= 100 || marks3 <= 0) {
//             throw new MarksOutOfBoundException(
//                     "Input marks of all subjects should be greater than 0 and less than 100");
//         } else {
//             System.out.println("\nStudent Details :\nName : " + name + "\nSeat Number: " + seatNo + "\nCenter Number : "
//                     + centerNo + "\nDate : " + date);
//             System.out.println(
//                     "Marks inMaths : " + marks + "\nMarks in physics : " + marks2 + "\nMarks in chemistry: " + marks3);
//         }
//     }
// }
