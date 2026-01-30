package regex;
public class ReplaceMultipleSpaces {
    public static void main(String[] args) {
        String text = "This    is    an     example";
        String result = text.replaceAll("\\s+", " ");
        System.out.println(result);
    }
}
