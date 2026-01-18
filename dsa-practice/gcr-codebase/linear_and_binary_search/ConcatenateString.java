package linear_and_binary_search;

public class ConcatenateString {
    public static String concatenateStrings(String[] arr) {
        StringBuffer sb = new StringBuffer();
        for(String str : arr) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] words = {"Java", " ", "is", " ", "high-level", " ", "language"};
        String result = concatenateStrings(words);
        System.out.println("Concatenated String: " + result);
    }
}
