package functional_interface;
import java.util.function.*;

public class StringLengthChecker {
	public static void main(String[] args) {
        int max = 20;
        Function<String, Integer> lenFun =
                message -> message.length();
        String msg = "Java is programming language";
        int len = lenFun.apply(msg);
        if(len>max) {
            System.out.println("Message exceeds character limit");
        }else {
            System.out.println("Message is within character limit");
        }
	}
}