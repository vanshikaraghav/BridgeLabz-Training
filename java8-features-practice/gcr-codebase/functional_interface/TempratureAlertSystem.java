package functional_interface;
import java.util.function.*;

public class TempratureAlertSystem {
	public static void main(String[] args) {
		double threshold = 34.5;
		Predicate<Double> tempAlert = temp -> temp > threshold;
		double curr = 15.5;
		if(tempAlert.test(curr)) {
			System.out.println("Alert! Temperature crossed normal range");
		}else {
			System.out.println("Temperature is normal");
		}
	}
}