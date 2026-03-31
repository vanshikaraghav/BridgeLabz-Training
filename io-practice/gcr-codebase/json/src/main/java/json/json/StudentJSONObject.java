package json.json;
import org.json.*;

public class StudentJSONObject {
	public static void main(String[] args) {
		JSONArray arr = new JSONArray();
		arr.put("Java");
		arr.put(".Net");
		JSONObject obj = new JSONObject();
		obj.put("name" ,"Harshita");
		obj.put("age", 22);
		obj.put("subjects", arr);
		System.out.println(obj.toString());
	}
}