package scenario_based;

public class EduQuiz {
    public static void main(String[] args) {
        String[] correctAnswers = {"A","B","C","D","A","C","B","D","A","C"};
        String[] studentAnswers = {"A","B","D","D","A","C","B","A","A","C"};
        int score = calculateScore(correctAnswers, studentAnswers);
        double percentage = (score / 10.0) * 100;
        System.out.println("\nScore: " + score + "/10");
        System.out.println("Percentage: " + percentage + "%");
        System.out.println(percentage >= 50 ? "Result: Pass" : "Result: Fail");
    }

    static int calculateScore(String[] correct, String[] student) {
        int score = 0;
        for(int i=0;i<correct.length;i++) {
            if(correct[i].equalsIgnoreCase(student[i])) {
                System.out.println("Question " + (i + 1) + ": Correct");
                score++;
            }else {
                System.out.println("Question " + (i + 1) + ": Incorrect");
            }
        }
        return score;
    }
}

