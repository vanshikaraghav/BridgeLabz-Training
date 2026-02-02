package annotation;
import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport{
	int count() default 0;
	String discription();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports{
	BugReport[] value();
	
}

class Report{
	@BugReport(count = 1 , discription = "Performance Bug")
	@BugReport(count = 2 , discription = "Security Bug")
	public void bug() {
		
	}
}
public class RepeatableAnnotation {
	public static void main(String[] args) throws Exception {
		Report rep = new Report();
		Method mth =  rep.getClass().getMethod("bug");
		BugReport[] annotation = mth.getDeclaredAnnotationsByType(BugReport.class);
		for(BugReport ant : annotation) {
			System.out.print(ant.count()+ ": ");
			System.out.println(ant.discription());
		}
	}
}