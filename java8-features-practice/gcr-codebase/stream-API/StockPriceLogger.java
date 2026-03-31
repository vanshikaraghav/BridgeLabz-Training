package stream_API;
import java.util.*;

public class StockPriceLogger {
    public static void main(String[] args) {
        List<Double> prices = List.of(101.5, 102.3, 99.8);
        prices.forEach(System.out::println);
    }
}