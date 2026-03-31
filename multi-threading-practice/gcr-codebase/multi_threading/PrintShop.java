package multi_threading;

class PrintJob implements Runnable {
    String jobName;
    int pages;

    PrintJob(String jobName, int pages) {
        this.jobName = jobName;
        this.pages = pages;
    }

    public void run() {
        for(int i = 1; i <= pages; i++) {
            System.out.println("Printing " + jobName +
                    " - Page " + i + " of " + pages);
            try {
                Thread.sleep(100);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class PrintShop {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread t1 = new Thread(new PrintJob("Job1", 10));
        Thread t2 = new Thread(new PrintJob("Job2", 5));
        Thread t3 = new Thread(new PrintJob("Job3", 15));
        Thread t4 = new Thread(new PrintJob("Job4", 8));
        Thread t5 = new Thread(new PrintJob("Job5", 12));
        t1.setPriority(5);
        t2.setPriority(8);
        t3.setPriority(3);
        t4.setPriority(6);
        t5.setPriority(7);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        System.out.println("All jobs completed in " +
                (System.currentTimeMillis() - start) + "ms");
    }
}
