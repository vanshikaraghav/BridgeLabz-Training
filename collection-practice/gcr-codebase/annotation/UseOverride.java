package annotation;

class Animal{
	public void makesound() {
		System.out.println("Noise");
	}
}
class Dog extends Animal{
	@Override
	public void makesound() {
		System.out.println("Dog Barks");
	}
}

public class UseOverride {
	public static void main(String[] args) {
		Animal d = new Dog();
		d.makesound();
	}
}