package reflections;
import java.lang.reflect.Field;

public class StaticField {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Configuration.class;
        Field field = cls.getDeclaredField("API_KEY");
        field.setAccessible(true);
        field.set(null, "NEW_SECRET_KEY");
        System.out.println("Updated API Key: " + Configuration.getApiKey());
    }
}