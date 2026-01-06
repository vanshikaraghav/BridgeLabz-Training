package scenario_based;

public class TempratureAnalyzer {
	
	public static void analyzeTemperature(float[][] temp) {
        float hotAvg = temp[0][0];
        float coldAvg = temp[0][0];
        int hotDay = 0;
        int coldDay = 0;
        for(int day=0;day<7;day++) {
            float sum = 0;
            for(int hour=0;hour<24;hour++) {
                sum += temp[day][hour];
            }
            float avg = sum/24;
            System.out.println("Average temperature of Day "+(day+1)+" : "+avg);
            if(avg>hotAvg) {
                hotAvg = avg;
                hotDay = day;
            }
            if(avg<coldAvg) {
                coldAvg = avg;
                coldDay = day;
            }
        }
        System.out.println("\nHottest Day: Day " + (hotDay + 1));
        System.out.println("Coldest Day: Day " + (coldDay + 1));
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float[][] temperatures = new float[7][24];
        for(int i=0;i<7;i++) {
            for(int j=0;j<24;j++) {
                temperatures[i][j] = 20 + i + j * 0.1f;
            }
        }
        analyzeTemperature(temperatures);
	}

}
