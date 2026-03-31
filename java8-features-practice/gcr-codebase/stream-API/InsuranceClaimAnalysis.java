package stream_API;
import java.util.*;
import java.util.stream.*;

class Claim {
    String type;
    double amount;

    Claim(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }
}

public class InsuranceClaimAnalysis {
    public static void main(String[] args) {
        List<Claim> claims = List.of(
                new Claim("Health", 55000),
                new Claim("Health", 35000),
                new Claim("Vehicle", 20000),
                new Claim("Vehicle", 42000)
        );
        Map<String, Double> avgClaims =
                claims.stream()
                        .collect(Collectors.groupingBy(
                                c -> c.type,
                                Collectors.averagingDouble(c -> c.amount)
                        ));
        avgClaims.forEach((k, v) -> System.out.println(k + " : " + v));
    }
}
