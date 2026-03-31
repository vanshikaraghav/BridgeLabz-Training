package stream_API;
import java.util.*;

public class EventAttendee {
    public static void main(String[] args) {

        List<String> attendees = List.of("Harshita", "Vanshika", "Neha");

        attendees.forEach(a ->
                System.out.println("Welcome to the event, " + a)
        );
    }
}