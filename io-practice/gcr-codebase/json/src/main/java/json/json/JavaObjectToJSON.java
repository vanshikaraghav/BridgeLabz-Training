package json.json;
import com.fasterxml.jackson.databind.*;

class Car{
	public String brand;
	public String colour;
	public int speed;
	
	public Car(String brand , String colour , int speed) {
		this.brand = brand;
		this.colour = colour;
		this.speed = speed;
	}
}

public class JavaObjectToJSON {
	public static void main(String[] args) {
		try {
			ObjectMapper obj = new ObjectMapper();
			Car car = new Car("Scorpio-N" , "Black" , 40);
			String json = obj.writeValueAsString(car);
			System.out.println(json);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}