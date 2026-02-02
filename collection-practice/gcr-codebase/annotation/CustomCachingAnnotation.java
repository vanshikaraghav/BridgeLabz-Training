package annotation;
import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {}

class MathService {

    @CacheResult
    public int expensiveSquare(int number) {
        System.out.println("Computing square...");
        return number * number;
    }
}

class CacheManager {

    private static final Map<String, Object> cache = new HashMap<>();

    public static Object invoke(Object obj, String methodName, int value)
            throws Exception {
        Method method = obj.getClass().getMethod(methodName, int.class);
        String key = methodName + "_" + value;
        if(method.isAnnotationPresent(CacheResult.class)) {
            if (cache.containsKey(key)) {
                System.out.println("Returning cached result");
                return cache.get(key);
            }
            Object result = method.invoke(obj, value);
            cache.put(key, result);
            return result;
        }
        return method.invoke(obj, value);
    }
}

public class CustomCachingAnnotation {
    public static void main(String[] args) throws Exception {
        MathService service = new MathService();
        System.out.println(CacheManager.invoke(service, "expensiveSquare", 5));
        System.out.println(CacheManager.invoke(service, "expensiveSquare", 5));
        System.out.println(CacheManager.invoke(service, "expensiveSquare", 6));
    }
}
