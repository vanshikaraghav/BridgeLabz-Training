package stack_queue_hashmap;
import java.util.*;

class MyQueue{
	Stack<Integer> stackEnqueue = new Stack<>();
	Stack<Integer> stackDequeue = new Stack<>();
	
	public void enqueue(int x) {
		stackEnqueue.push(x);
	}
	
	public int dequeue() {
		 if(stackEnqueue.isEmpty() && stackDequeue.isEmpty()) {
			 System.out.println("Queue is empty");
	         return -1;
		 }
	     if(stackDequeue.isEmpty()) {
	    	 while(!stackEnqueue.isEmpty()) {
	    		 stackDequeue.push(stackEnqueue.pop());
	    	 }
	     }
	     return stackDequeue.pop();
	}
	
	void display() {
        if(!stackDequeue.isEmpty()) {
            System.out.println("Front element: "+stackDequeue.peek());
        }else if (!stackEnqueue.isEmpty()) {
            System.out.println("Front element: "+stackEnqueue.firstElement());
        }else {
            System.out.println("Queue is empty");
        }
    }
}

public class QueueByStack {
	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.dequeue();
		queue.display();
	}
}
