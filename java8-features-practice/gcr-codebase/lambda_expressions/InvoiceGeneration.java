package lambda_expressions;
import java.util.*;
class Invoice{
	int transactionId;
	Invoice(int transactionId){
		this.transactionId=transactionId;
	}
	public String toString() {
		return "Invoice created for Transaction Id: "+transactionId;
	}
}
public class InvoiceGeneration {
public static void main(String[] args) {
	List<Integer> transactionIds=Arrays.asList(50001,50002,50003);
	List<Invoice> invoices=transactionIds.stream()
			.map(Invoice::new)
			.toList();
	invoices.forEach(System.out::println);
	}
}
