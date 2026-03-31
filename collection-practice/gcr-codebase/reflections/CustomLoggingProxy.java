package reflections;
import java.lang.reflect.*;

interface Greeting{
	void sayHello();
}

class GreetingsImplied implements Greeting{
	public void sayHello() {
		System.out.println("Hello, World!");
	}
}

class LoggingHandler implements InvocationHandler{
	
	private final Object target;
	
	public LoggingHandler(Object target) {
		this.target = target;
	}
	
	public Object invoke(Object proxy ,Method method , Object[] args )throws Throwable{
		System.out.println("Method name: " + method.getName());
		return method.invoke(target, args);
	}
}

public class CustomLoggingProxy {
	public static void main(String[] args) {
		Greeting greet = new GreetingsImplied();	
		Greeting proxy = (Greeting)Proxy.newProxyInstance(Greeting.class.getClassLoader(), new Class[] {Greeting.class}, new LoggingHandler(greet));
		proxy.sayHello();
	}
}