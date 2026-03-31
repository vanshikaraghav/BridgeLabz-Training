package annotation;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
}

class TaskService {

    @LogExecutionTime
    public void fastTask() {
        for (int i = 0; i < 1_000_000; i++);
    }

    @LogExecutionTime
    public void slowTask() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void normalTask() {
        System.out.println("Normal task (no logging)");
    }
}

class ExecutionTimeProcessor {

    public static void execute(Object obj) throws Exception {

        Class<?> clazz = obj.getClass();
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {

            if (method.isAnnotationPresent(LogExecutionTime.class)) {

                long start = System.nanoTime();
                method.invoke(obj);
                long end = System.nanoTime();

                System.out.println(
                    method.getName() + " executed in " +
                    (end - start) + " nanoseconds"
                );
            }
        }
    }
}

public class LogExecutionAnnotation {

    public static void main(String[] args) throws Exception {

        TaskService service = new TaskService();

        ExecutionTimeProcessor.execute(service);
    }
}
