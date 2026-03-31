package reflections;

public class DynamicObject {
	public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("reflections.Student");
        Object obj = cls.getDeclaredConstructor().newInstance();
        Student student = (Student) obj;
        student.display();
    }
}
