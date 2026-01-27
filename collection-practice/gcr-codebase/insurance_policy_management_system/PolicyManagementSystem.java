package insurance_policy_management_system;
import java.time.LocalDate;
import java.util.*;

public class PolicyManagementSystem {
	
    static class Policy {
        int policyNumber;
        String policyHolderName;
        LocalDate expiryDate;
        String coverageType;
        double premiumAmount;

        Policy(int policyNumber, String policyHolderName,
               LocalDate expiryDate, String coverageType, double premiumAmount) {
            this.policyNumber = policyNumber;
            this.policyHolderName = policyHolderName;
            this.expiryDate = expiryDate;
            this.coverageType = coverageType;
            this.premiumAmount = premiumAmount;
        }

        public int getPolicyNumber() {
            return policyNumber;
        }

        public LocalDate getExpiryDate() {
            return expiryDate;
        }

        public String getCoverageType() {
            return coverageType;
        }

        // uniqueness based on policy number
        @Override
        public boolean equals(Object obj) {
            if(this==obj) {
            	return true;
            }
            if(!(obj instanceof Policy)) {
            	return false;
            }
            Policy policy = (Policy) obj;
            return policyNumber == policy.policyNumber;
        }

        @Override
        public int hashCode() {
            return policyNumber;
        }

        @Override
        public String toString() {
            return policyNumber + " | " + policyHolderName + " | " + expiryDate + " | " + coverageType + " | ₹" + premiumAmount;
        }
    }

    public static void main(String[] args) {

        // HashSet
        Set<Policy> hashSet = new HashSet<>();

        // LinkedHashSet
        Set<Policy> linkedHashSet = new LinkedHashSet<>();

        // TreeSet
        Set<Policy> treeSet = new TreeSet<>( Comparator.comparing(Policy::getExpiryDate));
        Policy p1 = new Policy(101, "Harshita", LocalDate.now().plusDays(10), "Health", 5000);
        Policy p2 = new Policy(102, "Vanshika", LocalDate.now().plusDays(40), "Auto", 3000);
        Policy p3 = new Policy(103, "Aman", LocalDate.now().plusDays(20), "Home", 7000);
        Policy p4 = new Policy(101, "Duplicate Harshita", LocalDate.now().plusDays(15), "Health", 5000);
        Collections.addAll(hashSet, p1, p2, p3, p4);
        Collections.addAll(linkedHashSet, p1, p2, p3, p4);
        Collections.addAll(treeSet, p1, p2, p3, p4);
        System.out.println("\nAll Unique Policies (HashSet)");
        for(Policy p : hashSet) {
            System.out.println(p);
        }
        System.out.println("\nPolicies Expiring in Next 30 Days");
        LocalDate today = LocalDate.now();
        LocalDate next30 = today.plusDays(30);
        for(Policy p : hashSet) {
            if(!p.getExpiryDate().isBefore(today) &&
                !p.getExpiryDate().isAfter(next30)) {
                System.out.println(p);
            }
        }
        System.out.println("\nHealth Insurance Policies");
        for(Policy p : hashSet) {
            if(p.getCoverageType().equalsIgnoreCase("Health")) {
                System.out.println(p);
            }
        }
        System.out.println("\nPerformance Comparison");
        performanceTest(hashSet, "HashSet");
        performanceTest(linkedHashSet, "LinkedHashSet");
        performanceTest(treeSet, "TreeSet");
    }

    static void performanceTest(Set<Policy> set, String name) {
        Policy testPolicy = new Policy(9999, "Test User", LocalDate.now().plusDays(5), "Auto", 4000);
        long start, end;
        start = System.nanoTime();
        set.add(testPolicy);
        end = System.nanoTime();
        System.out.println(name + " Add Time: " + (end - start));
        start = System.nanoTime();
        set.contains(testPolicy);
        end = System.nanoTime();
        System.out.println(name + " Search Time: " + (end - start));
        start = System.nanoTime();
        set.remove(testPolicy);
        end = System.nanoTime();
        System.out.println(name + " Remove Time: " + (end - start));
    }
}
