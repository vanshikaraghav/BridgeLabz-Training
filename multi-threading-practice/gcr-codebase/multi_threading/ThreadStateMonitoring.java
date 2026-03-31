package multi_threading;

class TaskRunner extends Thread {
    public void run() {
        try {
            Thread.sleep(2000);
            for(int i = 0; i < 1000000; i++);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class StateMonitor extends Thread {
    private Thread[] threads;

    StateMonitor(Thread[] threads) {
        this.threads = threads;
    }

    public void run() {
        boolean running = true;

        while(running) {
            running = false;
            for(Thread t : threads) {
                System.out.println("[Monitor] " + t.getName() +
                        " is in " + t.getState() + " state at " +
                        java.time.LocalTime.now());
                if(t.getState() != Thread.State.TERMINATED) {
                    running = true;
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadStateMonitoring {
    public static void main(String[] args) {
        TaskRunner t1 = new TaskRunner();
        TaskRunner t2 = new TaskRunner();
        t1.setName("Task-1");
        t2.setName("Task-2");
        StateMonitor monitor = new StateMonitor(new Thread[]{t1, t2});
        t1.start();
        t2.start();
        monitor.start();
    }
}
