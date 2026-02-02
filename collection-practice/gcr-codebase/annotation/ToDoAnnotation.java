package annotation;
import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ToDo{
	String task();
	String assignedTo();
	String priority() default "MEDIUM";
}

class List{
	@ToDo(task = "read" , assignedTo = "Alice" , priority = "HIGH")
	public void Task1() {
	
	}
	@ToDo(task = "write" , assignedTo = "Bob" )
	public void Task2() {
	
	}
}

public class ToDoAnnotation {
	public static void main(String[] args) throws Exception{
		List list = new List();
		Method[] method = list.getClass().getDeclaredMethods();
		for(Method mtd : method) {
			if(mtd.isAnnotationPresent(ToDo.class)) {
				ToDo td = mtd.getAnnotation(ToDo.class);
				System.out.print(mtd.getName() + " :  ");
				System.out.print(td.task() + " > ");
				System.out.print(td.assignedTo() + " > ");
				System.out.println(td.priority());
			}
		}
		
	}
}