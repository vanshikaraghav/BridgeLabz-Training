package scenario_based;
import java.util.Scanner;
class InvalidFlightException extends Exception{
	public InvalidFlightException(String message) {
		super(message);
	}
}
class FlightUtil{
	public boolean validateFlightNumber(String flightNumber) throws InvalidFlightException{
		if(!flightNumber.matches("FL-[1-9][0-9]{3}")) {
			throw new InvalidFlightException("the flight number "+flightNumber+" is invalid");
		}
		return true;
	}
	public boolean validateFlightName(String flightName) throws InvalidFlightException{
		if(!(flightName.equals("Spicejet")||
			 flightName.equals("Vistara")||
			 flightName.equals("IndiGo")||
			 flightName.equals("Air Arabia"))) {
			throw new InvalidFlightException("The flight name: "+flightName+" is invaldd");
		}
		return true;
	}
	public boolean validatePassengerCount(int passengerCount, String flightName) throws InvalidFlightException{
		int maxCapacity=0;
		switch(flightName) {
		case "SpiceJet":
			maxCapacity=396;
			break;
		case "Vistara":
			maxCapacity=615;
			break;
		case "IndiGo":
			maxCapacity=230;
			break;
		case "Air Arabia":
			maxCapacity=130;
			break;
		}
		if(passengerCount<=0||passengerCount>maxCapacity) {
			throw new InvalidFlightException("passenger count "+passengerCount+ " is invalid ");
		}
		return true;
	}
	public double calculateFuelToFillTank(String flightName, double currentFuelLevel) throws InvalidFlightException{
		double maxFuel=0;
		switch(flightName) {
		case "SpiceJet":
			maxFuel=200000;
			break;
		case "Vistara":
			maxFuel=300000;
			break;
		case "IndiGo":
			maxFuel=250000;
			break;
		case "Air Arabia":
			maxFuel=150000;
			break;
		}
		if(currentFuelLevel<0||currentFuelLevel>maxFuel) {
			throw new InvalidFlightException("invalid fuel level for "+flightName);
		}
		return maxFuel-currentFuelLevel;
	}
}
public class aerovigil {
      public static void main(String[] args) {
    	  Scanner sc=new Scanner(System.in);
    	  FlightUtil util=new FlightUtil();
    	  System.out.println("Enter Flight Details");
    	  try {
    		  String input =sc.nextLine();
    		  String[] details=input.split(":");
    		  String flightNumber=details[0];
    		  String flightName=details[1];
    		  int passengerCount=Integer.parseInt(details[2]);
    		  double currentFuelLevel=Double.parseDouble(details[3]);
    		  
    		  util.validateFlightNumber(flightNumber);
    		  util.validateFlightName(flightName);
    		  util.validatePassengerCount(passengerCount, flightName);
    		  
    		  double fuelRequired=util.calculateFuelToFillTank(flightName, currentFuelLevel);
    		  System.out.println("Fuel required to fill the tank: "+fuelRequired+ " litres");
    	  }
    	  catch(InvalidFlightException e) {
    		  System.out.println(e.getMessage());
    	  }
    	  catch(Exception e) {
    		  System.out.println(e.getMessage());
    	  }
      }
}
