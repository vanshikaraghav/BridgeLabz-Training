package inheritance;

class Personn{
	 String name;
	 int id;

	 Personn(String name,int id) {
	     this.name = name;
	     this.id = id;
	 }

	 void showBasicInfo() {
	     System.out.println("Name: "+name+" | ID: "+id);
	 }
}

interface Worker {
void performDuties();
}

class Chef extends Personn implements Worker {
	 String specialty;

	 Chef(String name,int id,String specialty) {
	     super(name,id);
	     this.specialty = specialty;
	 }

	 public void performDuties() {
	     showBasicInfo();
	     System.out.println("Role: Chef");
	     System.out.println("Specialty: "+specialty);
	     System.out.println("Duties: Prepare meals and manage the kitchen.");
	 }
}

class Waiter extends Personn implements Worker {
	 int tableCount;

	 Waiter(String name,int id,int tableCount) {
	     super(name,id);
	     this.tableCount = tableCount;
	 }

	 public void performDuties() {
	     showBasicInfo();
	     System.out.println("Role: Waiter");
	     System.out.println("Tables Assigned: "+tableCount);
	     System.out.println("Duties: Serve food and attend to customers.");
	 }
}

public class RestaurantManagementSystem {
	public static void main(String[] args) {
	     Chef chef = new Chef("Aman",101,"Indian Cuisine");
	     Waiter waiter = new Waiter("Vanshika",102,5);
	     chef.performDuties();
	     System.out.println();
	     waiter.performDuties();
	 }
}
