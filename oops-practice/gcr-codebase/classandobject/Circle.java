package class_and_objects;

public class Circle {
	
	double radius;
	
    void calculateAreaAndCircumference() {
        double area = Math.PI*radius*radius;
        double circumference = 2*Math.PI*radius;
        System.out.printf("Area of circle: %.4f\n",area);
        System.out.printf("Circumference of circle: %.4f\n",circumference);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle area = new Circle();
		area.radius = 3;
		area.calculateAreaAndCircumference();
	}

}
