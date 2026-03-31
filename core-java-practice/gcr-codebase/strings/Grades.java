package strings;

import java.util.Random;

public class Grades {

		public static String[] STUDENTS = {"Harry", "Mike", "Will", "Lucas", "Aman"};
	    public static String[] SUBJECTS = {"Physics", "Chemistry", "Math"};

	    public static int[][] generateScores() {
	        Random rand = new Random();
	        int[][] scores = new int[STUDENTS.length][SUBJECTS.length];
	        for (int i = 0; i < STUDENTS.length; i++) {
	            for (int j = 0; j < SUBJECTS.length; j++) {
	                scores[i][j] = rand.nextInt(90) + 10; 
	            }
	        }
	        return scores;
	    }

	    public static double[][] calculateResult(int[][] scores) {
	        double[][] result = new double[STUDENTS.length][3]; 
	        for (int i = 0; i < scores.length; i++) {
	            int total = 0;
	            for (int j = 0; j < scores[i].length; j++) {
	                total += scores[i][j];
	            }
	            double avg = total / 3.0;
	            double percent = (total / 300.0) * 100;
	            result[i][0] = total;
	            result[i][1] = Math.round(avg * 100.0) / 100.0;
	            result[i][2] = Math.round(percent * 100.0) / 100.0;
	        }
	        return result;
	    }

	    public static char[][] calculateGrades(double[][] result) {
	        char[][] grades = new char[STUDENTS.length][1];
	        for (int i = 0; i < result.length; i++) {
	            double percent = result[i][2];
	            if (percent >= 80)
	                grades[i][0] = 'A';
	            else if (percent >= 70)
	                grades[i][0] = 'B';
	            else if (percent >= 60)
	                grades[i][0] = 'C';
	            else if (percent >= 50)
	                grades[i][0] = 'D';
	            else if (percent >= 40)
	                grades[i][0] = 'E';
	            else
	                grades[i][0] = 'R';
	        }
	        return grades;
	    }

	    public static void displayScoreCard(int[][] scores, double[][] result, char[][] grades) {
	        System.out.println("Name\tPhysics\tChemistry\tMath\tTotal\tAverage\tPercent\tGrade");
	        System.out.println("--------------------------------------------------------------");
	        for (int i = 0; i < STUDENTS.length; i++) {
	            System.out.print(STUDENTS[i] + "\t");
	            for (int j = 0; j < SUBJECTS.length; j++) {
	                System.out.print(scores[i][j] + "\t");
	            }
	            System.out.printf("%.0f\t%.2f\t%.2f\t%c%n",
	                    result[i][0], result[i][1], result[i][2], grades[i][0]);
	        }
	    }

	    public static void main(String[] args) {
	    	// TODO Auto-generated method stub
	    	int[][] scores = generateScores();
	        double[][] result = calculateResult(scores);
	        char[][] grades = calculateGrades(result);
	        displayScoreCard(scores, result, grades);
	}

}
