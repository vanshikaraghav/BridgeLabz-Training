package regex;
import java.util.regex.*;

public class ExtractLinks {
    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for info";
        Pattern pattern = Pattern.compile("https?://\\S+");
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
