package voting_system;
import java.util.*;

public class ElectionSystem implements ElectionService {

    ArrayList<Voter> voters = new ArrayList<>();
    ArrayList<Candidate> candidates = new ArrayList<>();
    ArrayList<Vote> votes = new ArrayList<>();

    public void registerVoter(Voter voter) {
        voters.add(voter);
    }

    public void addCandidate(Candidate candidate) {
        candidates.add(candidate);
    }

    public void castVote(int voterId, int candidateId) throws DuplicateVoteException {
        Voter voter = null;
        Candidate candidate = null;
        for(Voter v : voters) {
            if(v.voterId == voterId) {
                voter = v;
                break;
            }
        }
        if(voter == null || voter.hasVoted) {
            throw new DuplicateVoteException("Duplicate or invalid vote detected");
        }
        for(Candidate c : candidates) {
            if(c.candidateId == candidateId) {
                candidate = c;
                break;
            }
        }
        if(candidate != null) {
            candidate.votes++;
            voter.hasVoted = true;
            votes.add(new Vote(voterId, candidateId));
        }
    }

    public void declareResult() {
        System.out.println("Election Results");
        for(Candidate c : candidates) {
            System.out.println(c.name + " : " + c.votes + " votes");
        }
    }
}
