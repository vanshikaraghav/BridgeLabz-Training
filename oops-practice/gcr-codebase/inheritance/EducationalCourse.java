package inheritance;

class Course {
	 String courseName;
	 int duration; 

	 Course(String courseName,int duration) {
	     this.courseName = courseName;
	     this.duration = duration;
	 }

	 void showDetails() {
	     System.out.println("Course Name: "+courseName+" | Duration: "+duration+" weeks");
	 }
}

class OnlineCourse extends Course {
	 String platform;
	 boolean isRecorded;

	 OnlineCourse(String courseName,int duration,String platform,boolean isRecorded) {
	     super(courseName,duration);
	     this.platform = platform;
	     this.isRecorded = isRecorded;
	 }

	 void showDetails() {
	     super.showDetails();
	     System.out.println("Platform: "+platform+" | Recorded: "+(isRecorded ? "Yes":"No"));
	 }
}

class PaidOnlineCourse extends OnlineCourse {
	 double fee;
	 double discount;

	 PaidOnlineCourse(String courseName,int duration,String platform,boolean isRecorded,double fee,double discount) {
	     super(courseName,duration,platform,isRecorded);
	     this.fee = fee;
	     this.discount = discount;
	 }

	 void showDetails() {
	     super.showDetails();
	     System.out.println("Course Fee: "+fee+" | Discount: "+discount+"%");
	 }
}

public class EducationalCourse {
	public static void main(String[] args) {
		PaidOnlineCourse c = new PaidOnlineCourse("Figma",4,"Udemy",true,560.5,10);
		c.showDetails();
	}
}
