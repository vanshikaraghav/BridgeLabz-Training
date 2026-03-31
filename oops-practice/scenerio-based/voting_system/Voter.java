package voting_system;

public class Voter {
	int voterId;
    String name;
    boolean hasVoted = false;

    Voter(int voterId, String name) {
        this.voterId = voterId;
        this.name = name;
    }
}
