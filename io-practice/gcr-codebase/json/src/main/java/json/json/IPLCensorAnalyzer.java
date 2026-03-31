package json.json;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.*;

public class IPLCensorAnalyzer {

    // MODEL CLASS
    static class IPLMatch {
        public int match_id;
        public String team1;
        public String team2;
        public Map<String, Integer> score;
        public String winner;
        public String player_of_match;
    }

    // CENSOR UTIL
    static String maskTeam(String team) {
        String[] parts = team.split(" ");
        return parts[0] + " ***";
    }

    static String redactPlayer() {
        return "REDACTED";
    }

    static void censorJSON(String input, String output) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        IPLMatch[] matches =
                mapper.readValue(new File(input), IPLMatch[].class);
        for(IPLMatch m : matches) {
            m.team1 = maskTeam(m.team1);
            m.team2 = maskTeam(m.team2);
            m.winner = maskTeam(m.winner);
            m.player_of_match = redactPlayer();
            Map<String, Integer> newScore = new HashMap<>();
            for(Map.Entry<String, Integer> e : m.score.entrySet()) {
                newScore.put(maskTeam(e.getKey()), e.getValue());
            }
            m.score = newScore;
        }
        mapper.writerWithDefaultPrettyPrinter()
              .writeValue(new File(output), matches);
    }

    public static void censorCSV(String input, String output) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader(input));
        BufferedWriter bw = new BufferedWriter(new FileWriter(output));

        String line;

        // write header
        bw.write(br.readLine());
        bw.newLine();

        while ((line = br.readLine()) != null) {

            if (line.trim().isEmpty()) continue; // skip empty lines

            String[] parts = line.split(",");

            if (parts.length < 7) {
                System.out.println("Skipping invalid line: " + line);
                continue;
            }

            parts[1] = maskTeam(parts[1]);
            parts[2] = maskTeam(parts[2]);
            parts[6] = "REDACTED";

            bw.write(String.join(",", parts));
            bw.newLine();
        }

        br.close();
        bw.close();
    }


    public static void main(String[] args) {
        try {
            censorJSON("src/main/java/resources/ipl_input.json", "ipl_censored.json");
            censorCSV("src/main/java/resources/ipl_input.csv", "ipl_censored.csv");
            System.out.println("IPL data censored successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
