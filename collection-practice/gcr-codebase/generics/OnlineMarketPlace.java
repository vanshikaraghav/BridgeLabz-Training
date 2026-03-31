package generics;

interface Category {
 String getCategoryName();
}

class BookCategory implements Category {
	public String getCategoryName() {
        return "Books";
	}
}

class ClothingCategory implements Category {
	public String getCategoryName() {
        return "Clothing";
    }
}

class GadgetCategory implements Category {
    public String getCategoryName() {
        return "Gadgets";
    }
}

class Product<T extends Category> {
    private final String name;
    private double price;
    private final T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDetails() {
        return name + " | Category: " + category.getCategoryName() + " | Price: " + price;
    }
}

class DiscountUtil {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discount = product.getPrice() * (percentage / 100);
        product.setPrice(product.getPrice() - discount);
    }
}

public class OnlineMarketPlace {
    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Java Programming", 500, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("T-Shirt", 1000, new ClothingCategory());
        DiscountUtil.applyDiscount(book, 10);
        DiscountUtil.applyDiscount(shirt, 20);
        System.out.println(book.getDetails());
        System.out.println(shirt.getDetails());
    }
}
