package scenario_based;

class MathUtils {

    static int factorial(int n) {
        if(n<0) {
        	return -1;
        }
        int fact = 1;
        for(int i=1;i<=n;i++) {
            fact *= i;
        }
        return fact;
    }

    static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= n / 2; i++)
            if (n % i == 0) return false;
        return true;
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static int fibonacci(int n) {
        if (n < 0) return -1;
        if (n == 0) return 0;
        if (n == 1) return 1;

        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}

public class MathematicalUtilityOperations {
    public static void main(String[] args) {
        System.out.println("Factorial of 5: " + MathUtils.factorial(5));
        System.out.println("Is 7 Prime: " + MathUtils.isPrime(7));
        System.out.println("GCD of 12 and 18: " + MathUtils.gcd(12, 18));
        System.out.println("Fibonacci of 6: " + MathUtils.fibonacci(6));
    }
}


