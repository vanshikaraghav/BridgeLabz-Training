package constructors_and_variables;

public class Circle {
	
	double radius;

    Circle() {
        this(2.5); // constructor chaining
    }

    Circle(double radius) {
        this.radius = radius;
    }

    void display() {
        System.out.println("Radius: "+radius);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle c1 = new Circle();
		Circle c2 = new Circle();
		c1.display();
		c2.display();
	}

}
