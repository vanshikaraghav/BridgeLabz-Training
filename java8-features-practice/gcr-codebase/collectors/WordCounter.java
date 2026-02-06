package collectors;
import java.util.*;
import java.util.stream.Collectors;
public class WordCounter {
     public static void main(String[] args) {
    	 String paragraph="java is fun and java is powerful";
    	 Map<String,Integer>wordCount=Arrays.stream(paragraph.split(" "))
    			 .collect(Collectors.toMap(
    					 word->word,
    			         word->1,
    			         Integer::sum));
    	 System.out.println(wordCount);
    	 
    
     }
     }

