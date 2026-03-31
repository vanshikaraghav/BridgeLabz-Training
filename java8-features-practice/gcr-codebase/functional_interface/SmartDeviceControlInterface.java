package functional_interface;

interface SmartDevice{
	void turnOn();
	void turnOff();
}

class Light implements SmartDevice{
	public void turnOn() {
		System.out.println("Light turn On");
	}
	
	public void turnOff() {
		System.out.println("Light turn Off");
	}
}

class AC implements SmartDevice{
	public void turnOn() {
		System.out.println("AC turn On");
	}
	
	public void turnOff() {
		System.out.println("AC turn Off");
	}
}

class TV implements SmartDevice{
	public void turnOn() {
		System.out.println("TV turn On");
	}
	
	public void turnOff() {
		System.out.println("TV turn Off");
	}
}

public class SmartDeviceControlInterface {
	public static void main(String[] args) {
		SmartDevice light =  new Light();
		SmartDevice ac = new AC();
		SmartDevice tv = new TV();
		
		light.turnOn();
		ac.turnOn();
		tv.turnOn();
		
		light.turnOff();
		ac.turnOff();
		tv.turnOff();
	}
}