package Practice.Proc_Scheduling.RR;

import java.util.*;

public class RR{
	//Driver Code
	public static void main(String[] args){
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

            p[i] = new Process(i, at, bt);
        }

		System.out.print("Enter Time Quantum: ");
		int q = sc.nextInt();

        int burstTime[] = schedule(p,q);
        print(p, burstTime);

        sc.close();
	}






	private static int[] schedule(Process[] p, int q) {
		boolean completed[] = new boolean[p.length];
        Arrays.fill(completed, false);
		
		int burstTime[] = new int[p.length];
		for (int i = 0; i<p.length; i++){
			burstTime[i] = p[i].bt;
		}
		
		ArrayList<Process> waiting = new ArrayList<>();
		
		int noOfCompleted = 0;
        int current_Time = 0;
		
		int proc = 0;
		waiting.add(p[proc]);
		int x = 1;

        while(noOfCompleted != p.length && waiting.isEmpty() != true){
			int temp_timeQuantun = 0;
			// for//process
			while (temp_timeQuantun != q ){
				int process = waiting.get(0).id;
				proc = process;
				if (waiting.get(0).bt == 0 && completed[proc] != true){
					break;
				}
				p[process].bt--;
				temp_timeQuantun++;
				current_Time++;
			}
				for (; x<p.length;++x){
					if (p[x].at < current_Time){
						waiting.add(p[x]);
					}
				}

				if (p[proc].bt == 0){
					p[proc].ct = current_Time;
					p[proc].tat = p[proc].ct - p[proc].at;
					p[proc].wt = p[proc].tat - burstTime[proc];
					completed[proc]=true;
					noOfCompleted++;
				}
				else{
					waiting.add(p[proc]);
				}

				if (proc < p.length){
					proc++;
				}
				waiting.remove(0);
			
		}

		return burstTime;
	}














	private static void print(Process[] p, int[] burstTime) {
        System.out.println("\n\nProcess | Arrival Time | Burst Time | Completion Time | Turn Around Time | Waiting Time");
        for (int i = 0; i<p.length; i++){
            System.out.println(p[i].id+"\t|\t"+p[i].at+"\t|\t"+burstTime[i]+"\t|\t"+p[i].ct+"\t|\t"+p[i].tat+"\t|\t"+p[i].wt);
        }
    }

}

class Process{
    int id;
    int ct=0, bt=0, at=0, wt=0, tat=0;

    Process(int id, int at, int bt){
        this.id = id;
        this.at = at;
        this.bt = bt;
    }
}