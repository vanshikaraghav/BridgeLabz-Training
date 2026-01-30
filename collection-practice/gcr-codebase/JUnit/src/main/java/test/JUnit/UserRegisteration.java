package test.JUnit;
public class UserRegisteration {

    public void registerUser(String username, String email, String password) {
        if(username==null || username.length()<3) {
            throw new IllegalArgumentException("Invalid username");
        }
        if(!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Invalid email");
        }
        if(password.length()<8) {
            throw new IllegalArgumentException("Invalid password");
        }
    }
}