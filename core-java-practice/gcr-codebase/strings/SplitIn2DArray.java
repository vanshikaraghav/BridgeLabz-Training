package strings;

public class SplitIn2DArray {
	
	public static int length(String s) {
        int i = 0;
        try {
            while (true) {
                s.charAt(i++);
            }
        } catch (Exception e) {}
        return i;
    }

    public static String[][] wordsWithLength(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(length(words[i]));
        }
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"Hello", "nice", "you"};
        String[][] data = wordsWithLength(words);
        System.out.println("Word\tLength");
        for (String[] row : data) {
            System.out.println(row[0] + "\t" + Integer.parseInt(row[1]));
        }
	}

}
