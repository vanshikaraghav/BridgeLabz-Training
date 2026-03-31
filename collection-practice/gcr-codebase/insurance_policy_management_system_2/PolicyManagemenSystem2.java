package insurance_policy_management_system_2;
import java.time.LocalDate;
import java.util.*;

public class PolicyManagemenSystem2 {
	
    static class Policy {
        String policyNumber;
        String policyHolderName;
        LocalDate expiryDate;
        String coverageType;
        double premiumAmount;

        Policy(String policyNumber, String policyHolderName,LocalDate expiryDate, String coverageType, double premiumAmount) {
            this.policyNumber = policyNumber;
            this.policyHolderName = policyHolderName;
            this.expiryDate = expiryDate;
            this.coverageType = coverageType;
            this.premiumAmount = premiumAmount;
        }

        public String toString() {
            return policyNumber + " | " + policyHolderName + " | " +expiryDate + " | " + coverageType + " | ₹" + premiumAmount;
        }
    }

    // Fast lookup
    static Map<String, Policy> hashMap = new HashMap<>();

    // Maintains insertion order
    static Map<String, Policy> linkedHashMap = new LinkedHashMap<>();

    // Sorted by expiry date
    static TreeMap<LocalDate, List<Policy>> treeMap = new TreeMap<>();

    static void addPolicy(Policy policy) {
        hashMap.put(policy.policyNumber, policy);
        linkedHashMap.put(policy.policyNumber, policy);
        treeMap
            .computeIfAbsent(policy.expiryDate, k -> new ArrayList<>())
            .add(policy);
    }

    // Retrieve Policy by Number
    static Policy getPolicyByNumber(String policyNumber) {
        return hashMap.get(policyNumber);
    }

    // Policies Expiring in Next 30 Days
    static void policiesExpiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(30);
        System.out.println("\nPolicies expiring within 30 days:");
        for(Map.Entry<LocalDate, List<Policy>> entry : treeMap.entrySet()) {
            if(!entry.getKey().isBefore(today) && !entry.getKey().isAfter(limit)) {
                for(Policy p : entry.getValue()) {
                    System.out.println(p);
                }
            }
        }
    }

    // Policies by Policyholder
    static void policiesByHolder(String holderName) {
        System.out.println("\nPolicies for " + holderName + ":");
        for(Policy p : hashMap.values()) {
            if(p.policyHolderName.equalsIgnoreCase(holderName)) {
                System.out.println(p);
            }
        }
    }

    // Remove Expired Policies 
    static void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        Iterator<Map.Entry<String, Policy>> iterator = hashMap.entrySet().iterator();
        while(iterator.hasNext()) {
            Policy p = iterator.next().getValue();
            if(p.expiryDate.isBefore(today)) {
                iterator.remove();
                linkedHashMap.remove(p.policyNumber);
            }
        }
        treeMap.headMap(today).clear();
    }

    static void displayAll() {
        System.out.println("\nAll Policies (Insertion Order):");
        for(Policy p : linkedHashMap.values()) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        addPolicy(new Policy("P101", "Alice", LocalDate.now().plusDays(10), "Health", 5000));
        addPolicy(new Policy("P102", "Bob", LocalDate.now().plusDays(40), "Auto", 3000));
        addPolicy(new Policy("P103", "Alice", LocalDate.now().minusDays(5), "Home", 7000));
        addPolicy(new Policy("P104", "Charlie", LocalDate.now().plusDays(20), "Health", 4000));
        displayAll();
        System.out.println("\nRetrieve Policy P102:");
        System.out.println(getPolicyByNumber("P102"));
        policiesExpiringSoon();
        policiesByHolder("Alice");
        removeExpiredPolicies();
        System.out.println("\nAfter Removing Expired Policies:");
        displayAll();
    }
}
