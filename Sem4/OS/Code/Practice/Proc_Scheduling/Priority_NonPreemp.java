package Practice.Proc_Scheduling;

import java.util.Arrays;
import java.util.Scanner;

public class Priority_NonPreemp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("Enter the no. of CPU_processes: ");
        n = sc.nextInt();
        CPU_Process p[] = new CPU_Process[n];

        for (int i = 0; i<n; i++){

            System.out.println("CPU_Process "+(i+1));

            System.out.print("Enter Arrival time: ");
            int at = sc.nextInt();

            System.out.print("Enter Burst time: ");
            int bt = sc.nextInt();

            System.out.print("Enter Priority: ");
            int priority = sc.nextInt();

            p[i] = new CPU_Process("P"+(i+1), at, bt, priority);
        }

        schedule(p);
        print(p);

        sc.close();
    }

    private static void print(CPU_Process[] p) {
        System.out.println("\n\nCPU_Process | Arrival Time | Burst Time | Priority | Completion Time | Turn Around Time | Waiting Time");
        for (int i = 0; i<p.length; i++){
            System.out.println(p[i].id+"\t|\t"+p[i].at+"\t|\t"+p[i].bt+"\t|\t"+p[i].priority+"\t|\t"+p[i].ct+"\t|\t"+p[i].tat+"\t|\t"+p[i].wt);
        }
    }

    private static void schedule(CPU_Process[] p) {
        boolean completed[] = new boolean[p.length];
        Arrays.fill(completed, false);
        int noOfCompleted = 0;
        int current_Time = 0;
        while(noOfCompleted != p.length){
            int c =0;
            CPU_Process temp = null;
            int max_priority =-1;
            for (int i = 0; i<p.length; i++){
                if (p[i].at<=current_Time && p[i].priority>max_priority && completed[i] == false){
                    max_priority = p[i].priority;
                    temp = p[i];
                    c = i;
                }
            }

            if (temp == null){  //if we dont find any shortest job
                current_Time++;
                continue;
            }else{
                completed[c] = true;
                System.out.println("Current Time: " + current_Time + ", Executing CPU_Process: " + temp.id);
                p[c].ct = current_Time+p[c].bt;
                current_Time+=p[c].bt;
                p[c].tat = p[c].ct - p[c].at;
                p[c].wt = p[c].tat - p[c].bt;
                noOfCompleted++;
            }
        }
    }
}


class CPU_Process{
    String id;
    int ct=0, bt=0, at=0, wt=0, tat=0, priority=0;

    CPU_Process(String id, int at, int bt, int priority){
        this.id = id;
        this.at = at;
        this.bt = bt;
        this.priority = priority;
    }
}
