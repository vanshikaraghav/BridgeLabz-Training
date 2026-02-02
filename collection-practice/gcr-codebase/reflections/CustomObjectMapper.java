package reflections;
import java.lang.reflect.*;
import java.util.*;

class StudentInfo{
	private String name;
	private int age;

	public String display() {
		return "Student { name = " + name + " age = " + age +" }";
	}
}


public class CustomObjectMapper {
	public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) throws Exception {
		T obj = clazz.getDeclaredConstructor().newInstance();
		for(Map.Entry<String, Object> entry : properties.entrySet()) {
			Field field = clazz.getDeclaredField(entry.getKey());
			field.setAccessible(true);
			field.set(obj, entry.getValue());
		}
		return obj;
	}

	public static void main(String[] args) throws Exception {
		Map<String, Object> data = new HashMap<>();
		data.put("name", "Harshita");
		data.put("age", 22);
		StudentInfo stud = toObject(StudentInfo.class, data);
		System.out.println(stud.display());
	}
}