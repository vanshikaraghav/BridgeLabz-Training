package voting_system;

public class OnlineVotingSystem {
	public static void main(String[] args) {
        ElectionSystem election = new ElectionSystem();
        election.registerVoter(new Voter(1, "Aman"));
        election.registerVoter(new Voter(2, "Harshita"));
        election.addCandidate(new Candidate(101, "Candidate A"));
        election.addCandidate(new Candidate(102, "Candidate B"));
        try {
            election.castVote(1, 101);
            election.castVote(2, 102);
        }catch (DuplicateVoteException e) {
            System.out.println(e.getMessage());
        }

        election.declareResult();
    }
}
