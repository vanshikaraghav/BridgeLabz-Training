package inheritance;

class Device{
	String DeviceId;
	String status;
	
	Device(String DeviceId,String status){
		this.DeviceId = DeviceId;
		this.status = status;
	}
	
	void displayStatus() {
		System.out.println("DeviceId: "+DeviceId+" | Status: "+status);
	}
}

class Thermostat extends Device{
	float tempratureSetting;
	
	Thermostat(String DeviceId,String status,float tempratureSetting){
		super(DeviceId,status);
		this.tempratureSetting = tempratureSetting;
	}
	
	void displayStatus() {
		super.displayStatus();
		System.out.println("Temprature Setting: "+tempratureSetting);
	}
}

public class SmartHomeDevice {
	public static void main(String[] args) {
		Thermostat temp = new Thermostat("101","Good",16);
		temp.displayStatus();
	}
}
