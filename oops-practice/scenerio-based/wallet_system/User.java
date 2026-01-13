package wallet_system;

public class User {
	int userId;
    String name;
    Wallet wallet;

    User(int userId, String name) {
        this.userId = userId;
        this.name = name;
        wallet = new Wallet();
    }
}
