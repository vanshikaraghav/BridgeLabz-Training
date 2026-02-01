package scenario_based;
import java.util.*;
import java.util.regex.*;

abstract class GoodsTransport{
	protected String transportId;
	protected String transportDate;
	protected int transportRating;

	public String getTransportId() {
		return transportId;
	}

	public void setTransportId(String transportId) {
		this.transportId = transportId;
	}

	public String getTransportDate() {
		return transportDate;
	}

	public void setTransportDate(String transportDate) {
		this.transportDate = transportDate;
	}

	public int getTransportRating() {
		return transportRating;
	}

	public void setTransportRating(int transportRating) {
		this.transportRating = transportRating;
	}

	public GoodsTransport(String id , String date , int rate) {
		this.transportId = id;
		this.transportDate = date;
		this.transportRating = rate;
	}
	
	abstract public String vehicleSelection() ;

	abstract public float calculateTotalCharge();
}

class BrickTransport extends GoodsTransport{
	private float brickSize;
	private int brickQuantity;
	private float brickPrice;
	
	public BrickTransport(String id, String date, int rate , float size , int quantity , float price) {
		super(id, date, rate);
		this.brickSize = size;
		this.brickQuantity = quantity;
		this.brickPrice = price;
	}
	
	public float getBrickSize() {
		return brickSize;
	}
	
	public void setBrickSize(float brickSize) {
		this.brickSize = brickSize;
	}
	
	public int getBrickQuantity() {
		return brickQuantity;
	}
	
	public void setBrickQuantity(int brickQuantity) {
		this.brickQuantity = brickQuantity;
	}
	
	public float getBrickPrice() {
		return brickPrice;
	}
	
	public void setBrickPrice(float brickPrice) {
		this.brickPrice = brickPrice;
	}
	
	@Override
	public String vehicleSelection() {
		if(brickQuantity < 300) {
			return "Truck";
		}else if(brickQuantity >= 300 && brickQuantity <= 500) {
			return "Lorry";
		}else {
			return "MonsterLorry";
		}
	}
	
	@Override
	public float calculateTotalCharge() {
		double disper ;
		if(transportRating == 5) {
			disper = 0.20;
		}else if(transportRating == 3 || transportRating == 4) {
			disper = 0.10;
		}else {
			disper = 0;
		}
		float price = brickPrice * brickQuantity ;
		float Tax = (float) (price * 0.3) ;
		double Discount = price * disper;
		int vehicleprice ;
		String str = vehicleSelection();
		if(str.equalsIgnoreCase("Truck")) {
			vehicleprice = 1000;
		}else if(str.equalsIgnoreCase("Lorry")) {
			vehicleprice = 1700;
		}else {
			vehicleprice = 3000;
		}
		float totalcharge = (float) ((price + vehicleprice + Tax) - Discount);
		return totalcharge;
	}
}

class TimberTransport extends GoodsTransport{
	private float timberLength;
	private float timberRadius;
	private String timberType;
	private float timberPrice;
	
	public TimberTransport(String id, String date, int rate , float length , float radius , String type , float price) {
		super(id, date, rate);
		this.timberLength = length;
		this.timberRadius = radius;
		this.timberType = type;
		this.timberPrice = price;
	}
	
	public float gettimberLength() {
		return timberLength;
	}
	
	public void settimberLength(float timberLength) {
		this.timberLength = timberLength;
	}
	
	public float gettimberRadius() {
		return timberRadius;
	}
	
	public void settimberRadius(float timberRadius) {
		this.timberRadius = timberRadius;
	}
	
	public String gettimberType() {
		return timberType;
	}
	
	public void settimberType(String timberType) {
		this.timberType = timberType;
	}
	
	public float gettimberPrice() {
		return timberPrice;
	}
	
	public void settimberPrice(float timberPrice) {
		this.timberPrice = timberPrice;
	}
	
	@Override
	public String vehicleSelection() {
		float Area = (float) (2 * 3.147 * timberRadius * timberLength);
		if(Area < 250) {
			return "Truck";
		}else if (Area >= 250 && Area <= 400) {
			return "Lorry";
		}else {
			return "MonsterLorry" ;
		}
	}
	
	public float calculateTotalCharge() {
		double Volume = 3.147 * timberRadius * timberRadius * timberLength;
		double type;
		if(timberType.equalsIgnoreCase("Premium")) {
			type = 0.25;
		}else {
			type = 0.15;
		}
		double Price = Volume * timberPrice * type;
		double Tax = Price * 0.3;
		double disper ;
		if(transportRating == 5) {
			disper = 0.20;
		}else if(transportRating == 3 || transportRating == 4) {
			disper = 0.10;
		}else {
			disper = 0;
		}
		double discount = Price * disper;
		int vehicleprice ;
		String str = vehicleSelection();
		if(str.equalsIgnoreCase("Truck")) {
			vehicleprice = 1000;
		}else if(str.equalsIgnoreCase("Lorry")) {
			vehicleprice = 1700;
		}else {
			vehicleprice = 3000;
		}
		float totalcharge = (float)((Price + vehicleprice + Tax) - discount);
		return totalcharge;
	}
}

class Utility{
	public GoodsTransport parseDetails(String input) {
		String[] details = input.split(":");
		String transID = details[0];
		String tranDate = details[1];
		int tranRate = Integer.parseInt(details[2]);
		String type = details[3];
		if(!validateTransportId(transID)) {
			return null;
		}
		if(type.equalsIgnoreCase("Bricktransport")) {
			return new BrickTransport( transID , tranDate, tranRate , 
					Float.parseFloat(details[4]),
					Integer.parseInt(details[5]),
					Float.parseFloat(details[6])
					);
		}
		if(type.equalsIgnoreCase("Timbertransport")) {
			return new TimberTransport(transID , tranDate , tranRate,
					Float.parseFloat(details[4]),
					Float.parseFloat(details[5]),
					details[6], Float.parseFloat(details[7]));
		}
		return null;
	}
	
	public boolean validateTransportId (String str) {
		String regex = "^RTS\\d{3}[A-Z]$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		if(!matcher.matches()) {
			System.out.println("Transport Id " + str + " is invalid.");
			System.out.println("Please provide a valid record. ");
			return false;
		}
		return true;
	}
	
	public String findObjectType(GoodsTransport goods) {
		if(goods instanceof BrickTransport ) {
			return "BrickTransport";
		}
		if(goods instanceof TimberTransport) {
			return "TimberTransport";
		}
		return "Invalid Transport";
	}
}

public class FutureLogistics {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Utility utility = new Utility();
		System.out.println("Enter transport details: ");
		String input = sc.nextLine();
		GoodsTransport goods = utility.parseDetails(input);
		if(goods==null) {
			return;
		}
		String type = utility.findObjectType(goods);
		float total = goods.calculateTotalCharge();
        System.out.println("Transporter Id: " + goods.getTransportId());
        System.out.println("Date of Transport: " + goods.getTransportDate());
        System.out.println("Rating of the Transport: " + goods.getTransportRating());
        if(type.equalsIgnoreCase("bricktransport")) {
            BrickTransport bt = (BrickTransport) goods;
            System.out.println("Quantity of bricks : " + bt.getBrickQuantity());
            System.out.println("Brick price : " + bt.getBrickPrice());
        }
        if(type.equalsIgnoreCase("Timbertransport")) {
            TimberTransport tt = (TimberTransport) goods;
            System.out.println("Type of Timber : " + tt.gettimberType());
            System.out.println("Timber price per kilo : " + tt.gettimberPrice());
        }
        System.out.println("Vehicle Selected: "+goods.vehicleSelection());
        System.out.println("Total Charge: " + total);
	}
}