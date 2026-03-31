package annotation;
import java.util.*;

public class SuppressUncheckedWarning {
	@SuppressWarnings({"unchecked" })
	public static void main(String[] args) {
		ArrayList arr = new ArrayList();
		arr.add("java");
		arr.add(10);
		arr.add(1.25);
		System.out.println(arr);
	}
}