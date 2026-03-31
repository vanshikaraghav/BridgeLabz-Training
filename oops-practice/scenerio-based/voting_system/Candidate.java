package voting_system;

public class Candidate {
	int candidateId;
    String name;
    int votes = 0;

    Candidate(int candidateId, String name) {
        this.candidateId = candidateId;
        this.name = name;
    }
}
