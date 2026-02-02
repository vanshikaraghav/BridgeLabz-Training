package reflections;
import java.lang.reflect.Method;
import java.util.Scanner;

public class DynamicMethodCall {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter method name (add/subtract/multiply): ");
        String methodName = sc.next();
        Class<?> cls = Class.forName("reflections.MathOperations");
        Object obj = cls.getDeclaredConstructor().newInstance();
        Method method = cls.getMethod(methodName, int.class, int.class);
        Object result = method.invoke(obj, 10, 5);
        System.out.println("Result: " + result);
    }
}