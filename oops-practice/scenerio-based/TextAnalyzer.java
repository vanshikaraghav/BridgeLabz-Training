package scenario_based;

public class TextAnalyzer {
	
	 public static void analyzeText(String paragraph, String word, String newWord) {
		 if(paragraph==null || paragraph.trim().isEmpty()) {
	         System.out.println("Paragraph is empty. No analysis possible.");
	            return;
	        }
	     String[] words = paragraph.trim().split("\\s+");
	     int wordCount = words.length;     // count words
	     String longestWord = words[0];     // Find longest word
         for(String word1 : words) {
	         if(word1.length()>longestWord.length()) {
	                longestWord = word1;
	            }
         }
	        String replacedParagraph = paragraph.replaceAll("(?i)\\b"+word+"\\b",newWord);
	        System.out.println("Original Paragraph:");
	        System.out.println(paragraph);
	        System.out.println();
	        System.out.println("Word Count: "+wordCount);
	        System.out.println("Longest Word: "+longestWord);
	        System.out.println("Updated Paragraph: ");
	        System.out.println(replacedParagraph);
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String paragraph = "Java is an object-oriented programming language.";
        String Word = "Java";
        String newWord = "Python";
        analyzeText(paragraph, Word, newWord);
	}

}
