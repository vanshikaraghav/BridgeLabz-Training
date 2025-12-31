package class_and_objects;

public class MobilePhone {
	
	String brand;
    String model;
    double price;

    void displayMobilePhoneDetails() {
        System.out.println("Brand of mobile: "+brand);
        System.out.println("Model of mobile: "+model);
        System.out.println("Price of mobile: "+price);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MobilePhone phone1 = new MobilePhone();
		phone1.brand = "VIVO";
		phone1.model = "VIVO V29";
		phone1.price = 15999.0;
		MobilePhone phone2 = new MobilePhone();
        phone2.brand = "ONE PLUS";
        phone2.model = "ONE PLUS nord4";
        phone2.price = 39999.0;

        MobilePhone phone3 = new MobilePhone();
        phone3.brand = "APPLE";
        phone3.model = "iphone pro16";
        phone3.price = 79999.0;
        phone1.displayMobilePhoneDetails();
        System.out.println("------------------------------");
        phone2.displayMobilePhoneDetails();
        System.out.println("------------------------------");
        phone3.displayMobilePhoneDetails();
	}

}
