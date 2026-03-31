package reflections;
import java.lang.reflect.Field;

public class JsonUtil {

    public static String toJson(Object obj) throws Exception {
        StringBuilder json = new StringBuilder("{");
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields) {
            field.setAccessible(true);
            json.append("\"")
                .append(field.getName())
                .append("\":\"")
                .append(field.get(obj))
                .append("\",");
        }
        json.deleteCharAt(json.length() - 1); 
        json.append("}");
        return json.toString();
    }
}
