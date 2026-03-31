package annotation;

import java.lang.annotation.*;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class Userr {

    @JsonField(name = "user_name")
    private String name;

    @JsonField(name = "user_age")
    private int age;

    private String password; 

    public Userr(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }
}

class JsonUtil {

    public static String toJson(Object obj) throws IllegalAccessException {
        StringBuilder json = new StringBuilder("{");
        Field[] fields = obj.getClass().getDeclaredFields();
        for(Field field : fields) {
            if(field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);
                JsonField annotation = field.getAnnotation(JsonField.class);
                String key = annotation.name();
                Object value = field.get(obj);
                json.append("\"").append(key).append("\":\"")
                    .append(value).append("\",");
            }
        }
        json.deleteCharAt(json.length() - 1);
        json.append("}");
        return json.toString();
    }
}

public class JsonSerialization {

    public static void main(String[] args) throws Exception {
        Userr user = new Userr("Harshita", 22, "secret123");
        String json = JsonUtil.toJson(user);
        System.out.println(json);
    }
}
