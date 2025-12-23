package strings;

public class NullPointerExceptionDemo {

	public static void generateException() {
		String text = null;
		System.out.println(text.length());
	}

	public static void handleException() {
		try {
			String text = null;
			System.out.println(text.length());
		} catch (NullPointerException e) {
			System.out.println("NullPointerException handled");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generateException();
		handleException();
	}
}