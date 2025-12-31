package class_and_objects;

public class Item {
	
	String itemCode;
    String itemName;
    double price;
    
    void displayItemDetails() {
        System.out.println("ItemCode : "+itemCode);
        System.out.println("ItemPrice : "+price);
        System.out.println("ItemName : "+itemName);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Item item1 = new Item();
        item1.itemCode = "01AA";
        item1.price = 500.0;
        item1.itemName = "Water bottle";
        Item item2 = new Item();
        item2.itemCode = "01BB";
        item2.price = 700.0;
        item2.itemName = "Rice";
        Item item3 = new Item();
        item3.itemCode = "02AA";
        item3.price = 400.0;
        item3.itemName = "blackboard";
        item1.displayItemDetails();
        System.out.println("----------------------------");
        item2.displayItemDetails();
        System.out.println("----------------------------");
        item3.displayItemDetails();
	}

}
