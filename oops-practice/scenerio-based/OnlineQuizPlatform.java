package scenario_based;
import java.util.ArrayList;
import java.util.List;

class InvalidQuizSubmissionException extends Exception {
    InvalidQuizSubmissionException(String msg) {
        super(msg);
    }
}

public class OnlineQuizPlatform {
	
	public static int calculateScore(String[] correct, String[] user) throws InvalidQuizSubmissionException {
        if(correct.length != user.length) {
            throw new InvalidQuizSubmissionException("Answer length mismatch");
        }
        int score = 0;
        for(int i = 0; i < correct.length; i++) {
            if (correct[i].equalsIgnoreCase(user[i])) {
                score++;
            }
        }
        return score;
    }

    public static String getGrade(int score, int total) {
        double percent = (score * 100.0) / total;
        if(percent >= 80) {
        	return "A";
        }
        if(percent >= 60) {
        	return "B";
        }
        if(percent >= 40) {
        	return "C";
        }
        return "Fail";
    }

    public static void main(String[] args) {
        String[] correctAnswers = {"A", "B", "C", "D"};
        String[] userAnswers = {"A", "b", "C", "A"};
        List<Integer> scores = new ArrayList<>();
        try{
            int score = calculateScore(correctAnswers, userAnswers);
            scores.add(score);
            System.out.println("Score: " + score);
            System.out.println("Grade: " + getGrade(score, correctAnswers.length));
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("All Scores: " + scores);
    }
}
