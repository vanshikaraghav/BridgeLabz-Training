package inheritance;

class Animal{
	String name;
	int age;
	
	Animal(String name ,int age){
		this.name=name;
		this.age=age;
	}
	
	void makeSound() {
		System.out.println("Make sound");
	} 

}
class Dog extends Animal{

	Dog(String name, int age){
		super(name, age);
	}
	
	void makeSound(){
		System.out.println(name+" says: Woof Woof");
	}
}

class Cat extends Animal{
	 Cat(String name,int age){
	     super(name, age);
	 }

	 void makeSound(){
	     System.out.println(name+" says: Meow Meow");
	 }
}

class Bird extends Animal{
	 Bird(String name,int age){
	     super(name, age);
	 }

	 void makeSound(){
	     System.out.println(name+" says: Chirp Chirp");
	 }
}

public class AnimalHierarchy{
	public static void main(String args[]){
        Animal a1 = new Dog("Tommy", 3);
        Animal a2 = new Cat("kitty", 2);
        Animal a3 = new Bird("Birdie", 1);
        a1.makeSound();
        a2.makeSound();
        a3.makeSound();
	}
}
