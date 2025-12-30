package scenario_based;

public class DigitalWatchSimulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int hour=0;hour<24;hour++) {
            for(int minute=0;minute<60;minute++) {
                if(hour==13 && minute==0) {
                    System.out.println("Power cut at 13:00!");
                    break;
                }
                System.out.println(hour+":"+(minute<10 ? "0"+minute : minute));
            }
            if(hour==13) {
                break;
            }
        }
	}

}
