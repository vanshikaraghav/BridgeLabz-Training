package reflections;
import java.lang.reflect.Field;

class Studentt {
	private int id;
    private String name;
    private double marks;

    public Studentt(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
}

class JsonConverter {

 public static String toJson(Object obj) throws IllegalAccessException {
     Class<?> clazz = obj.getClass();
     Field[] fields = clazz.getDeclaredFields();
     StringBuilder json = new StringBuilder("{");
     for(Field field : fields) {
         field.setAccessible(true);  
         json.append("\"")
             .append(field.getName())
             .append("\": ")
             .append("\"")
             .append(field.get(obj))
             .append("\", ");
     }
     json.delete(json.length() - 2, json.length());
     json.append("}");
     return json.toString();
    }
}

public class ObjectToJson {
    public static void main(String[] args) throws Exception {
        Studentt student = new Studentt(101, "Harshita", 89.5);
        String json = JsonConverter.toJson(student);
        System.out.println(json);
    }
}
