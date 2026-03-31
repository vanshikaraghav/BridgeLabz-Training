package lambda_expressions;
interface LightAction{
	void activate();
}
public class lighting_automation {
      public static void main(String[] main) {
    	  LightAction motionTrigger=()->
    	  System.out.println("Lights turned ON at full brightness");
    	  LightAction nightTrigger=()->
    	  System.out.println("Light turned ON with dim light");
    	  LightAction voiceTrigger=()->
    	  System.out.println("Light turned ON with custom light");
    	  
    	  motionTrigger.activate();
    	  nightTrigger.activate();
    	  voiceTrigger.activate();
      }
}
