package reflections;
import java.lang.reflect.Field;

class Person {
    private int age = 20;
}

public class AccessPrivateFields {
	public static void main(String[] args) throws Exception {
        Person person = new Person();
        Class<?> cls = person.getClass();
        Field field = cls.getDeclaredField("age");
        field.setAccessible(true); 
        System.out.println("Old Age: " + field.get(person));
        field.set(person, 30);
        System.out.println("New Age: " + field.get(person));
    }
}
