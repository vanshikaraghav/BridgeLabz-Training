package voting_system;

public class Vote {
	int voterId;
    int candidateId;

    Vote(int voterId, int candidateId) {
        this.voterId = voterId;
        this.candidateId = candidateId;
    }
}
