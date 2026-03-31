package collectors;
import java.util.*;
import java.util.stream.Collectors;
public class StudentCollector{
static class Student{
	private String name;
	private String grade;
	
	public Student(String name, String grade) {
		this.name=name;
		this.grade=grade;
	}
	public String getName() {
		return name;
	}
	public String getGrade() {
		return grade;
	}
}
public static void main(String[] args) {
	List<Student> students=List.of(
	new Student ("amit","C"),
	new Student ("kushal","B"),
	new Student ("arpit","A"),
	new Student ("kunal","A"),
	new Student ("Raman","C")
			);
	Map<String,List<String>> studentsByGrade=students.stream().collect(Collectors.groupingBy(Student::getGrade,Collectors.mapping(Student::getName,Collectors.toList())));
   System.out.println(studentsByGrade);
}
}
