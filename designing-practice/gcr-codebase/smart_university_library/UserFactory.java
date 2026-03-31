package smart_university_library;

interface User extends Observer{
	void showRole();
}

class Student implements User{

	private String name ;
	public Student(String name) {
		this.name = name;
	}
	
	@Override
	public void update(String msg) {
		System.out.println(name + " is notified: " + msg);
	}

	@Override
	public void showRole() {
		System.out.println(name + "is a Student");
	}
	
}

class faculty implements User{
	
	private String name ;
	public faculty (String name) {
		this.name = name;
	}
	
	@Override
	public void update(String msg) {
		System.out.println(name + " is notified: " + msg);
	}

	@Override
	public void showRole() {
		System.out.println(name + " is faculty.");
	}
}

class Librarian implements User{
	
	private String name;
	public Librarian(String name) {
		this.name = name;
	}
	
	@Override
	public void update(String msg) {
		System.out.println(name + " is notified: " + msg);
	}

	@Override
	public void showRole() {
		System.out.println(name + " is librarian.");
	}
}

public class UserFactory {
	public static User createUser(String type , String  name) throws Exception {
		switch(type.toLowerCase()) {
		case "student" : return new Student(name);
		case "faculty" : return new faculty(name);
		case "librarian" : return new Librarian(name);
		default : throw new Exception("Unknown Type");
		}
	}
}