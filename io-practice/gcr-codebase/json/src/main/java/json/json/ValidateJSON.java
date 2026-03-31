package json.json;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateJSON {
	
	public static void main(String[] args) {
		String json = "{ \"name\": \"Harshita\", \"age\": 22 }";
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.readTree(json);  
			System.out.println("true");
		} catch (Exception e) {
			System.out.println("false");
		}
	}
}