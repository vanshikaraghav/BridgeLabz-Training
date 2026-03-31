package stack_queue_hashmap;
import java.util.*;

public class StockSpan {
	
	public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();
        span[0] = 1;
        stack.push(0);
        for(int i=1;i<n;i++) {
            while(!stack.isEmpty() && prices[i] >= prices[stack.peek()]) {
                stack.pop();
            }
            span[i] = stack.isEmpty() ? (i+1) : (i-stack.peek());
            stack.push(i);
        }
        return span;
    }

    public static void main(String[] args) {
    	
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] span = calculateSpan(prices);
        for(int s : span) {
            System.out.print(s+" ");
        }
    }
}
