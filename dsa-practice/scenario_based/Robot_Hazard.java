package scenario_based;
import java.util.*; 

class RobotSafetyException extends Exception{
	public RobotSafetyException (String message) {
		super(message);
	}
}
class RobotHazardAuditor{
	public double CalculateHazardRisk(double armPrecision,int workerDensity, String machineryState)
	throws RobotSafetyException{
		if(armPrecision<0.0||armPrecision>1.0) {
			throw new RobotSafetyException("error: arm precision should be 0.0-1.0");
		}
		if(workerDensity<1||workerDensity>20) {
			throw new RobotSafetyException("error: worker density must be 1-20");
		}
		double machineRiskFactor;
		if(machineryState.equals("Worn")) {
		machineRiskFactor=1.3;
		}
		else if(machineryState.equals("Faulty")) {
			machineRiskFactor=2.0;
		}
		else if(machineryState.equals("Critical")) {
			machineRiskFactor=3.0;
		}
		else {
			throw new RobotSafetyException("error:unsupported machinery state ");
		}
		return ((1.0-armPrecision)*15.0)+(workerDensity*machineRiskFactor);
	}
}
public class Robot_Hazard{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		RobotHazardAuditor auditor=new RobotHazardAuditor();
		try {
			System.out.println("Enter arm precision 0.0-1.0");
			double armprecision=sc.nextDouble();
			System.out.println("Enter worker density 1-20");
			int workerDensity=sc.nextInt();
			sc.nextLine();
			System.out.println("enter machinery state(Worn,Faulty,Critical)");
			String machineryState=sc.nextLine();
			double risk=auditor.CalculateHazardRisk(armprecision,workerDensity,machineryState);
			System.out.println("Robot Hazard Risk Score"+ risk);
		}
		catch(RobotSafetyException e){
			System.out.println(e.getMessage());
			
		}
	}
}

