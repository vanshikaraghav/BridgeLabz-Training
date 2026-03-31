package stream_API;
import java.util.*;

public class EmailNotifications {

    static void sendEmailNotification(String email) {
        System.out.println("Email sent to " + email);
    }

    public static void main(String[] args) {
        List<String> emails = List.of("harshi@gmail.com", "b@gmail.com");
        emails.forEach(email -> sendEmailNotification(email));
    }
}
