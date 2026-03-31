package stream_API;
import java.util.*;

public class TransformingNames {
    public static void main(String[] args) {

        List<String> names = List.of("Harshita", "Vanshika", "neha");

        names.stream()
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }
}