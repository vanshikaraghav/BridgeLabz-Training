package annotation;
import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface RoleAllowed{
	String value();
}

@RoleAllowed(value = "ADMIN")
class userADMIN{
	public void performtask() {
		System.out.println("ADMIN is performing task.");
	}
}

class Security{
	public static void invoke(Object obj , String user) throws Exception {
		Class<?> cls = obj.getClass();
		if(cls.isAnnotationPresent(RoleAllowed.class)) {
			RoleAllowed role = cls.getAnnotation(RoleAllowed.class);
			if(!role.value().equals(user)) {
				System.out.println("Access Denied");
				return;
			}
		}
	}
}

public class RoleAllowedAnnotation  {
	public static void main(String[] args) throws Exception{
		userADMIN admin = new userADMIN();
		String user  = "Harshita";
		Security.invoke(admin, user);
	}
}