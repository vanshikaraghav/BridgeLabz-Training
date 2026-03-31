package methods;
import java.util.Scanner;

public class NoOfHandshakes {
	
	public static int calculateHandShakes(int n) {
		return (n*(n-1))/2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int maximumHandshakes = calculateHandShakes(n);
		System.out.println("The possible handshakes are "+maximumHandshakes);
	}

}
