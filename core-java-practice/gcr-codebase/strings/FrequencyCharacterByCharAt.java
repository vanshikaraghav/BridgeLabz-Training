package strings;

import java.util.Scanner;

public class FrequencyCharacterByCharAt {

	public static String[][] findFrequency(String text) {
        int[] freq = new int[256];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }
        int count = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                count++;
            }
        }
        String[][] result = new String[count][2];
        int index = 0;

        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                result[index][0] = Character.toString((char) i);
                result[index][1] = String.valueOf(freq[i]);
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[][] output = findFrequency(input);
        System.out.println("\nCharacter Frequency:");
        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i][0] + " -> " + output[i][1]);
        }
	}

}
