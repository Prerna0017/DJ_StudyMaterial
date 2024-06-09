package Practice.Proc_Scheduling;
import java.util.Scanner;


public class FIFO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("Enter the no. of processes: ");
        n = sc.nextInt();
        Process p[] = new Process[n];

        for (int i = 0; i<n; i++){

            System.out.println("Process "+(i+1));

            System.out.print("Enter Arrival time: ");
            int at = sc.nextInt();

            System.out.print("Enter Burst time: ");
            int bt = sc.nextInt();

            p[i] = new Process("P"+(i+1), at, bt);
        }

        schedule(p);
        print(p);

        sc.close();
    }

    private static void print(Process[] p) {
      
        System.out.println("Gantt Chart:");
        for (int i = 0; i < p.length; i++) {
            System.out.print(p[i].id + "\t | \t");
        }
        System.out.println();
        for (int i = 0; i < p.length; i++) {
            System.out.print(p[i].ct + "\t | \t");
        }


        System.out.println("\n\nProcess | Arrival Time | Burst Time | Completion Time | Turn Around Time | Waiting Time");
        for (int i = 0; i<p.length; i++){
            System.out.println(p[i].id+"\t|\t"+p[i].at+"\t|\t"+p[i].bt+"\t|\t"+p[i].ct+"\t|\t"+p[i].tat+"\t|\t"+p[i].wt);
        }
    }

    private static void schedule(Process[] p) {
        for (int i = 0; i<p.length; i++){
            if (i == 0){
                p[i].ct = p[i].bt;
            }
            else{
                p[i].ct = p[i].bt + p[i-1].ct;
            }
            p[i].tat = p[i].ct - p[i].at;
            p[i].wt = p[i].tat - p[i].bt;
        }
    }
}

class Process{
    String id;
    int ct=0, bt=0, at=0, wt=0, tat=0;

    Process(String id, int at, int bt){
        this.id = id;
        this.at = at;
        this.bt = bt;
    }


}
