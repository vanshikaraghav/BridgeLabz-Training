package runtime_analysis_BigO;
public class CompareFibonnaci {

    // Recursive Fibonnaci
    static int fibonacciRecursive(int n) {
        if(n<=1) {
            return n;
        }
        return fibonacciRecursive(n-1)+fibonacciRecursive(n-2);
    }

    // Iterative Fibonacci
    static int fibonacciIterative(int n) {
        if(n<=1) {
            return n;
        }
        int a = 0, b = 1, sum = 0;
        for(int i=2;i<=n;i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int n = 30; 
        long start = System.currentTimeMillis();
        int recResult = fibonacciRecursive(n);
        long end = System.currentTimeMillis();
        System.out.println("Recursive Fibonacci Result: " + recResult);
        System.out.println("Recursive Time: " + (end - start) + " ms");
        start = System.currentTimeMillis();
        int iterResult = fibonacciIterative(n);
        end = System.currentTimeMillis();
        System.out.println("Iterative Fibonacci Result: " + iterResult);
        System.out.println("Iterative Time: " + (end - start) + " ms");
    }
}
