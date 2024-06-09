import java.util.Scanner;

// Code after applying synchronization –
class BusReservation extends Thread {
    int vacant = 2, required;

    BusReservation(int r) {
        required = r;
    }

    public synchronized void run() {
        System.out.println("Welcome " + Thread.currentThread().getName() + "!");

        System.out.println("No. of seats left: " + vacant);
        if (required <= vacant) {
            System.out.println(required + " tickets have been booked");
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
            vacant -= required;
        } else {
            System.out.println("All tickets booked");
        }
    }
}

class ReserveTicketSync {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the No. Required Seats: ");
        int req = sc.nextInt();
        BusReservation br = new BusReservation(req);
        Thread t1 = new Thread(br);
        Thread t2 = new Thread(br);
        t1.setName("Thread A");
        t2.setName("Thread B");
        t1.start();
        t2.start();
        sc.close();
    }
}
