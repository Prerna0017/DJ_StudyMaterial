import java.util.Scanner;
 
class FCFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of Process: ");
        int n = sc.nextInt();
        Process[] p = new Process[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Process " + (i + 1));
            System.out.print("Enter the arrival time: ");
            int at = sc.nextInt();
            System.out.print("Enter the burst time: ");
            int bt = sc.nextInt();
            p[i] = new Process("P" + i, at, bt);
        }

        scheduleFCFS(p);
        printTable(p);
        sc.close();
    }

    private static void printTable(Process[] p) {
        int totalWt = 0;
        int totalTAT = 0;
        System.out.println(
                "\n\nProcess ID | Arrival Time | Burst Time | Completion Time | Turnaround Time | Waiting Time");
        for (int i = 0; i < p.length; i++) {
            System.out.println(p[i].id + "\t\t" + p[i].at + "\t\t" + p[i].bt + "\t\t" + p[i].ct + "\t\t" + p[i].tat
                    + "\t\t" + p[i].wt + "\t\t");
            totalTAT += p[i].tat;
            totalWt += p[i].wt;
        }

        System.out.println("Average TAT: " + (totalTAT / p.length));
        System.out.println("Average WT: " + (totalWt / p.length));
    }

    static void scheduleFCFS(Process[] p) {
        String[] processesInCPU = new String[p.length];

        for (int i = 0; i < p.length; i++) {
            processesInCPU[i] = p[i].id;
            if (i == 0) {
                p[i].setData(p[i].bt);

            } else {
                p[i].setData(p[i - 1].ct + p[i].bt);
            }
            int tat = p[i].ct - p[i].at;
            int wt = tat - p[i].bt;
            p[i].setData2(tat, wt);
        }

        System.out.println("Gantt Chart:");
        for (int i = 0; i < p.length; i++) {
            System.out.print(p[i].id + "\t | \t");
        }
        System.out.println();
        for (int i = 0; i < p.length; i++) {
            System.out.print(p[i].ct + "\t | \t");
        }
    }
}

class Process {
    String id;
    int at = 0, bt = 0, ct = 0, wt = 0, tat = 0;

    Process(String id, int at2, int bt2) {
        this.at = at2;
        this.bt = bt2;
        this.id = id;
    }

    void setData(int ct) {
        this.ct = ct;
    }

    void setData2(int tat, int wt) {
        this.tat = tat;
        this.wt = wt;
    }
}