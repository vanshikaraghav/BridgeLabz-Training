package stack_queue_hashmap;
import java.util.*;

public class StackByRecursion {
	
	static void sortStack(Stack<Integer> stack) {
        if(!stack.isEmpty()) {
            int top = stack.pop();
            sortStack(stack);
            insertInSortedOrder(stack, top);
        }
    }

    static void insertInSortedOrder(Stack<Integer> stack, int data) {
        if(stack.isEmpty() || data>stack.peek()) {
            stack.push(data);
            return;
        }

        int top = stack.pop();
        insertInSortedOrder(stack, data);
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(30);
        stack.push(10);
        stack.push(20);
        stack.push(5);
        System.out.println("Original Stack: "+stack);
        sortStack(stack);
        System.out.println("Sorted Stack: "+stack);
    }
}