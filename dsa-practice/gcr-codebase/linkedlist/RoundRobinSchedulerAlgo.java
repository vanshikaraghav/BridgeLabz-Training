package linkedlist;
import java.util.*;

class Process {
    int id, burst, priority, remaining;
    Process next;

    Process(int id, int burst, int priority) {
        this.id = id;
        this.burst = burst;
        this.remaining = burst;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private Process head = null, tail = null;

    public void addProcess(int id, int burst, int priority) {
        Process p = new Process(id, burst, priority);
        if(head == null) {
            head = tail = p;
            tail.next = head;
        }else {
            tail.next = p;
            tail = p;
            tail.next = head;
        }
    }

    public void removeProcess(int id) {
        if(head == null) {
        	return;
        }
        Process curr = head, prev = tail;
        do{
            if(curr.id == id) {
                if(curr == head) {
                    head = head.next;
                    tail.next = head;
                }else {
                    prev.next = curr.next;
                    if(curr == tail) {
                        tail = prev;
                    }
                }
                if(curr == curr.next) {
                    head = tail = null;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    public void simulate(int quantum) {
        if(head == null) {
        	return;
        }
        int time = 0;
        Map<Integer, Integer> wt = new HashMap<>();
        Map<Integer, Integer> tat = new HashMap<>();
        Process curr = head;
        while (head != null) {
            if(curr.remaining > 0) {
                int executed = Math.min(curr.remaining, quantum);
                curr.remaining -= executed;
                time += executed;
                if(curr.remaining == 0) {
                    tat.put(curr.id, time);
                    wt.put(curr.id, tat.get(curr.id) - curr.burst);
                    Process toRemove = curr;
                    curr = curr.next;
                    removeProcess(toRemove.id);
                    if(head == null) {
                    	break;
                    }
                }else {
                    curr = curr.next;
                }
                display();
            }
        }
        int totalWt = 0, totalTat = 0;
        for(int id : wt.keySet()) {
            totalWt += wt.get(id);
            totalTat += tat.get(id);
        }
        System.out.println("Average Waiting Time: " + (float) totalWt / wt.size());
        System.out.println("Average Turnaround Time: " + (float) totalTat / tat.size());
    }
    public void display() {
        if(head == null) {
            System.out.println("No processes.");
            return;
        }
        Process temp = head;
        System.out.print("Processes: ");
        do {
            System.out.print("[ID:" + temp.id + ", BT:" + temp.burst + ", Rem:" + temp.remaining + "] -> ");
            temp = temp.next;
        }while (temp != head);
        System.out.println();
    }
}

public class RoundRobinSchedulerAlgo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RoundRobinScheduler rr = new RoundRobinScheduler();
        while(true) {
            System.out.println("1.Add \n2.Display \n3.Simulate \n0.Exit");
            int ch = Integer.parseInt(sc.nextLine());
            if(ch == 0) {
            	break;
            }
            switch(ch) {
                case 1:
                    System.out.print("ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Burst Time: ");
                    int bt = Integer.parseInt(sc.nextLine());
                    System.out.print("Priority: ");
                    int pr = Integer.parseInt(sc.nextLine());
                    rr.addProcess(id, bt, pr);
                    break;
                case 2:
                    rr.display();
                    break;
                case 3:
                    System.out.print("Enter Quantum: ");
                    int q = Integer.parseInt(sc.nextLine());
                    rr.simulate(q);
                    break;
            }
        }
    }
}