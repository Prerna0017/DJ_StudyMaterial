package Exp12;
class Movie extends Thread {
    int vacant = 1, required;
    Movie(int x) {
        required = x;
    }
    public synchronized void run() {
        if (required <= vacant) {
            System.out.println(required + " for " +
                    Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
            vacant = vacant - required;
        } else {
            System.out.println("none for " +
                    Thread.currentThread().getName());
        }
    }
}
class Code2_ThreadSync {
    public static void main(String z[]) {
        System.out.println("Prerna Sunil Jadhav - 60004220127");
        Movie m = new Movie(1);
        Thread t1 = new Thread(m);
        Thread t2 = new Thread(m);
        t1.setName("Prerna");
        t2.setName("Jadhav");
        t1.start();
        t2.start();
    }
}
