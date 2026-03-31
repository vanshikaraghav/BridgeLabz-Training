package voting_system;
import java.util.*;

public class VotingSystem {

    private HashMap<String, Integer> voteCount = new HashMap<>();
    private LinkedHashMap<String, Integer> voteOrder = new LinkedHashMap<>();

    public void castVote(String candidate) {
        voteCount.put(candidate, voteCount.getOrDefault(candidate, 0) + 1);
        voteOrder.put(candidate, voteCount.get(candidate));
    }

    public void displayVoteOrder() {
        System.out.println("\nVotes in order of casting:");
        for(Map.Entry<String, Integer> entry : voteOrder.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public void displaySortedResults() {
        System.out.println("\nFinal Results (Sorted):");
        TreeMap<String, Integer> sortedResults = new TreeMap<>(voteCount);
        for(Map.Entry<String, Integer> entry : sortedResults.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public void displayWinner() {
        String winner = null;
        int maxVotes = 0;
        for(Map.Entry<String, Integer> entry : voteCount.entrySet()) {
            if(entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }
        System.out.println("\nWinner: " + winner + " with " + maxVotes + " votes");
    }

    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();
        system.castVote("Alice");
        system.castVote("Bob");
        system.castVote("Alice");
        system.castVote("Charlie");
        system.castVote("Bob");
        system.castVote("Alice");
        system.displayVoteOrder();
        system.displaySortedResults();
        system.displayWinner();
    }
}
