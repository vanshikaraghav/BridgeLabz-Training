package reflections;
import java.lang.reflect.Method;

class Task {

    public void longTask() throws InterruptedException {
        Thread.sleep(1500);
        System.out.println("Task completed");
    }
}

class MethodTimer {

    public static void measureTime(Object obj, String methodName) throws Exception {
        Method method = obj.getClass().getMethod(methodName);
        long start = System.currentTimeMillis();
        method.invoke(obj);
        long end = System.currentTimeMillis();
        System.out.println("Execution Time: " + (end - start) + " ms");
    }
}

public class MethodTiming {
    public static void main(String[] args) throws Exception {
        Task task = new Task();
        MethodTimer.measureTime(task, "longTask");
    }
}
