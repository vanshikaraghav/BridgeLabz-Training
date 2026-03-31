package queue_interface;
import java.util.*;

public class GenerateBinaryNumber {
	static List<String> generateBinary(int n) {
        List<String> result = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        q.add("1");
        for(int i=1;i<=n;i++) {
            String current = q.remove();
            result.add(current);
            q.add(current + "0");
            q.add(current + "1");
        }
        return result;
    }
	
	public static void main(String[] args) {
		System.out.println("Binary Numbers: " + generateBinary(5));
	}
}
