package Practice.Proc_Scheduling.RR;

public class RoundRobin {

    public static void main(String[] args) {
        int n = 4;
        CPUprocess proc[] = new CPUprocess[n];
        proc[0] = new CPUprocess(1,10);
        proc[1] = new CPUprocess(2,4);
        proc[2] = new CPUprocess(3,5);
        proc[3] = new CPUprocess(4,3);
        // proc[4] = new CPUprocess(5,4);
        
         int quantam=3;
         
        findavg(proc,n,quantam);
    }
    

static void findwaitingtime(CPUprocess proc[],int n,int quantam){
    int rem_bt[] = new int[n];
    for(int i=0;i<n;i++)
        rem_bt[i]=proc[i].bt;
    
    int t=0,i;
    while(true){
        int done=1;
        for(i=0;i<n;i++){
            if(rem_bt[i]>0){
                done=0;
                if(rem_bt[i]>quantam){
                    t+=quantam;
                    rem_bt[i]-=quantam;
                    System.out.print("P"+(i+1)+"|");
                }
                else{
                    t=t+rem_bt[i];
                    proc[i].wt=t-proc[i].bt;
                    rem_bt[i]=0;
                    System.out.print("P"+(i+1)+"|");
                }
            }
        }
        if(done==1)
        break;
    }
    for(i=0;i<n;i++){
        proc[i].tat=proc[i].wt+proc[i].bt;
    }
}

static void findavg(CPUprocess proc[],int n, int quantam){
    int total_wt=0,total_tat=0;
    
    findwaitingtime(proc,n,quantam);
    
    System.out.println("\nP\t\tBT\t\tWT\t\tTAT\t\t\n");
    for (int i = 0; i < n; i++) {
        total_wt = total_wt + proc[i].wt;
        total_tat = total_tat + proc[i].tat;
        System.out.println(" "+proc[i].pid + "\t\t" + proc[i].bt + "\t\t " + proc[i].wt + "\t\t " + proc[i].tat);
    }

    System.out.println("\nAverage waiting time = "+ (float)total_wt / (float)n);
    System.out.println("\nAverage turn around time = " + (float)total_tat / (float)n);
}
}
    

class CPUprocess{
    int pid;
    int bt;
    int tat;
    int wt;

    CPUprocess(int pid, int bt){
        this.pid = pid;
        this.bt = bt;
    }
}