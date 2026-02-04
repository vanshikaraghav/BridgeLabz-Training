package lambda_expressions;
import java.util.*;
public class name_uppercasting {
public static void main(String[] args) {
	List<String> employees=Arrays.asList("Rahul","Nehal","Aryan");
	employees.stream()
	.map(String::toUpperCase)
	.forEach(System.out::println);
} 
}
