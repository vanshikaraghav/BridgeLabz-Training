package reflections;
import java.lang.reflect.*;

public class ClassInformation {
    public static void main(String[] args) throws Exception {
        String className = "java.util.ArrayList";
        Class<?> cls = Class.forName(className);
        System.out.println("Class Name: " + cls.getName());
        System.out.println("\nFields:");
        Field[] fields = cls.getDeclaredFields();
        for(Field field : fields) {
            System.out.println(field.getName());
        }
        System.out.println("\nMethods:");
        Method[] methods = cls.getDeclaredMethods();
        for(Method method : methods) {
            System.out.println(method.getName());
        }
        System.out.println("\nConstructors:");
        Constructor<?>[] constructors = cls.getDeclaredConstructors();
        for(Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
    }
}
