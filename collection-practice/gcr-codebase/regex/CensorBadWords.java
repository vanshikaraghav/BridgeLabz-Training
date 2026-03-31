package regex;
public class CensorBadWords {
    public static void main(String[] args) {
        String text = "This is a damn bad example with some stupid words.";
        String result = text.replaceAll("\\b(damn|stupid)\\b", "****");
        System.out.println(result);
    }
}
