package annotation;
import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength{
	int value();
}

class User{

	@MaxLength(value = 6)
	String username;

	public User(String username) {
		validate(username);
		this.username = username;
	}

	public void validate(String username) {
		try {
			Field field = this.getClass().getDeclaredField("username");
			if(field.isAnnotationPresent(MaxLength.class)) {
				MaxLength len = field.getAnnotation(MaxLength.class);
				if(username.length() > len.value()) {
					throw new IllegalArgumentException (
							"User Name exceeds max length of: " + len.value());
				}else {
					System.out.println("Length of Username: " + username.length());
				}
			}
		}
		catch(NoSuchFieldException e) {
			e.printStackTrace();
		}
	}
}

public class MaxLengthAnnotation {
	public static void main(String[] args){
		new User("Aman");
		new User("NoSuchFieldException");
	}
}
