package constructors_and_variables;

public class Course {
	
	String courseName;
	int duration;
	double fees;
	static String institudeName = "GLA University";
	
	Course(String courseName,int duration,double fees){
		this.courseName = courseName;
		this.duration = duration;
		this.fees = fees;
	}
	
	void displayCourseDetails() {
		System.out.println("Course: "+courseName+" | Duration: "+duration+" | Fees: "+fees+" | Institude: "+institudeName);
	}
	
	void updateInstituteName(String name) {
		institudeName = name;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Course c1 = new Course("BTech",4,800000);
		c1.displayCourseDetails();
		c1.updateInstituteName("GL Bajaj");
		c1.displayCourseDetails();
	}

}
