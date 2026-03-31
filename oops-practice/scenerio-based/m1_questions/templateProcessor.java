package m1_questions;

import java.util.*;
import java.util.regex.*;
import java.time.*;

public class templateProcessor {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Pattern pattern = Pattern.compile("\\$\\{(\\w+):(.*?)\\}");

        while(n-- > 0){

            String line = sc.nextLine();
            Matcher m = pattern.matcher(line);

            StringBuffer result = new StringBuffer();

            while(m.find()){
                String type = m.group(1);
                String value = m.group(2);

                String replacement = process(type, value);

                m.appendReplacement(result, replacement);
            }
            m.appendTail(result);

            System.out.println(result.toString());
        }
    }

    static String process(String type, String value){

        try{
            switch(type){

                case "UPPER":
                    return value.toUpperCase();

                case "LOWER":
                    return value.toLowerCase();

                case "DATE":
                    LocalDate d = LocalDate.parse(value,
                            java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                    return d.toString().replace("-", "/");

                case "REPEAT":
                    String[] parts = value.split(",");
                    String word = parts[0];
                    int count = Integer.parseInt(parts[1]);

                    StringBuilder sb = new StringBuilder();
                    for(int i=0;i<count;i++) sb.append(word);
                    return sb.toString();
            }
        }catch(Exception e){
            return "INVALID";
        }

        return "INVALID";
    }
}
