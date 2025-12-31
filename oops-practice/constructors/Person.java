package constructors_and_variables;

public class Person {
	
	String name;
	int age;
	String dob;
	
	Person(String name,int age,String dob){
		this.name = name;
		this.age = age;
		this.dob = dob;
	}
	
	Person(Person p1){
		this.name = p1.name;
		this.age = p1.age;
		this.dob = p1.dob;
	}
	
	void display() {
		System.out.println("Name: "+name+" | age: "+age+" | dob: "+dob);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person pr1 = new Person("Harshita",21,"6-10-2004");
		Person pr2 = new Person(pr1);
		pr1.display();
		pr2.display();
	}

}
