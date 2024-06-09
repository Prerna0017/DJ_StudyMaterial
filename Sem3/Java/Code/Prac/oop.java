import java.util.Scanner;
interface Sports {
    int score = 100;
    void member_score();
}
class Student {
    int roll_no;
    void read(int n) {
        roll_no = n;
    }
    void display() {
        System.out.println(roll_no);
    }
}
class Test extends Student {
    int sem1_marks, sem2_marks;
    void read1(int n) {
        sem1_marks = n;
    }
    void read2(int n) {
        sem2_marks = n;
    }
    void display() {
        System.out.println(sem1_marks + sem1_marks);
    }
}
class Result extends Test implements Sports {
    int total;
    public void member_score() {
        this.total = sem1_marks + sem2_marks + score;
        System.out.println("The total score is " + this.total);
    }
}
public class oop {
    public static void main(String args[]) {
        System.out.println("Prerna Jadhav - 60004220127");
        Scanner s = new Scanner(System.in);
        Result r = new Result();
        System.out.println("Enter roll no.");
        int roll = s.nextInt();
        System.out.println("Enter sem1.");
        int sem1 = s.nextInt();
        System.out.println("Enter sem2.");
        int sem2 = s.nextInt();
        r.read(roll);
        r.read1(sem1);
        r.read2(sem2);
        r.member_score();
        s.close();
    }
}


