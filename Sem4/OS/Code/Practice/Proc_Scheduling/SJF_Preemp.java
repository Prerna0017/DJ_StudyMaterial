package Practice.Proc_Scheduling;

import java.util.Arrays;
import java.util.Scanner;

public class SJF_Preemp {
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
        System.out.println("\n\nProcess | Arrival Time | Burst Time | Completion Time | Turn Around Time | Waiting Time");
        for (int i = 0; i<p.length; i++){
            System.out.println(p[i].id+"\t|\t"+p[i].at+"\t|\t"+p[i].bt+"\t|\t"+p[i].ct+"\t|\t"+p[i].tat+"\t|\t"+p[i].wt);
        }
    }

    private static void schedule(Process[] p) {
        boolean completed[] = new boolean[p.length];
        Arrays.fill(completed, false);
        int burstTime[] = new int[p.length];
        for (int z = 0; z<p.length; z++){
            burstTime[z] = p[z].bt;
        }
        int noOfCompleted = 0;
        int current_Time = 0;
        while(noOfCompleted != p.length){
            int c =0;
            Process temp = null;
            int min_burst_time =100000;
            for (int i = 0; i<p.length; i++){
                if (p[i].at<=current_Time && burstTime[i]<min_burst_time && completed[i] == false && burstTime[i] > 0){
                    min_burst_time = burstTime[i];
                    temp = p[i];
                    c = i;
                }
            }

            if (temp == null){  //if we dont find any shortest job
                current_Time++;
                continue;
            }else{
                System.out.println("Current Time: " + current_Time + ", Executing Process: " + temp.id);
                burstTime[c]--;
                current_Time++;
            }

            if (burstTime[c] == 0){
                completed[c] = true;
                p[c].ct = current_Time;
                p[c].tat = p[c].ct - p[c].at;
                p[c].wt = p[c].tat - p[c].bt;
                noOfCompleted++;
            }
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
