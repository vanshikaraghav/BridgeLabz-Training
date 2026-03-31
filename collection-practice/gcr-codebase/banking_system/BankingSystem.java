package banking_system;
import java.util.*;

public class BankingSystem {
    private HashMap<Integer, Double> accounts = new HashMap<>();
    private Queue<WithdrawalRequest> withdrawalQueue = new LinkedList<>();

    public void addAccount(int accNo, double balance) {
        accounts.put(accNo, balance);
    }

    public void displayAccounts() {
        System.out.println("\nAll Accounts:");
        for(Map.Entry<Integer, Double> entry : accounts.entrySet()) {
            System.out.println("Account " + entry.getKey() + " -> ₹" + entry.getValue());
        }
    }

    public void displaySortedByBalance() {
        System.out.println("\nAccounts Sorted by Balance:");
        TreeMap<Double, Integer> sortedMap = new TreeMap<>();
        for(Map.Entry<Integer, Double> entry : accounts.entrySet()) {
            sortedMap.put(entry.getValue(), entry.getKey());
        }
        for(Map.Entry<Double, Integer> entry : sortedMap.entrySet()) {
            System.out.println("Account " + entry.getValue() + " -> ₹" + entry.getKey());
        }
    }

    public void requestWithdrawal(int accNo, double amount) {
        withdrawalQueue.add(new WithdrawalRequest(accNo, amount));
    }

    public void processWithdrawals() {
        System.out.println("\nProcessing Withdrawals:");
        while(!withdrawalQueue.isEmpty()) {
            WithdrawalRequest req = withdrawalQueue.poll();
            if(!accounts.containsKey(req.accountNumber)) {
                System.out.println("Account " + req.accountNumber + " not found");
                continue;
            }
            double balance = accounts.get(req.accountNumber);
            if(balance >= req.amount) {
                accounts.put(req.accountNumber, balance - req.amount);
                System.out.println("Withdrawal successful from Account " + req.accountNumber + " Amount: ₹" + req.amount);
            }else {
                System.out.println("Insufficient balance in Account " + req.accountNumber);
            }
        }
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        bank.addAccount(101, 5000);
        bank.addAccount(102, 15000);
        bank.addAccount(103, 8000);
        bank.displayAccounts();
        bank.requestWithdrawal(101, 2000);
        bank.requestWithdrawal(103, 9000);
        bank.requestWithdrawal(102, 5000);
        bank.processWithdrawals();
        bank.displayAccounts();
        bank.displaySortedByBalance();
    }
}

class WithdrawalRequest {
    int accountNumber;
    double amount;

    WithdrawalRequest(int accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }
}
