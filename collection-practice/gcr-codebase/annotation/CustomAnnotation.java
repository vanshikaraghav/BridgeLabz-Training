package annotation;
import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo{
	int priority();
	String AssignedTo();
	String msg() default "No Task Due";
}

class TaskManager{
	@TaskInfo(priority = 1 , AssignedTo = "John")
	public void Task() {
		System.out.println("Task Completed");
	}
}

public class CustomAnnotation {
	public static void main(String[] args) throws Exception {
		TaskManager mng = new TaskManager();
		Method mtd = mng.getClass().getMethod("Task");
		if(mtd.isAnnotationPresent(TaskInfo.class)) {
			TaskInfo ant = mtd.getAnnotation(TaskInfo.class);
			System.out.println("Priority: " + ant.priority());
			System.out.println("Assigned To: " + ant.AssignedTo());
		}
	}
}