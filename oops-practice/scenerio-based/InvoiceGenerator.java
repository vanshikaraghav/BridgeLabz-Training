package scenario_based;

class InvalidInvoiceFormatException extends Exception {
    public InvalidInvoiceFormatException(String message) {
        super(message);
    }
}

public class InvoiceGenerator {

    public static String[] parseInvoice(String input) throws InvalidInvoiceFormatException {
        if(input == null || input.trim().isEmpty()) {
            throw new InvalidInvoiceFormatException("Invoice input is empty");
        }
        String[] tasks = input.split(",");
        for(String task : tasks) {
            if(!task.contains("-")) {
                throw new InvalidInvoiceFormatException("Invalid format: '-' missing");
            }
            String[] parts = task.split("-");
            if(parts.length != 2 || !parts[1].matches(".*\\d+.*")) {
                throw new InvalidInvoiceFormatException("Invalid amount format");
            }
        }
        return tasks;
    }

    public static int getTotalAmount(String[] tasks) {
        int total = 0;
        for(String task : tasks) {
            String amountPart = task.split("-")[1];
            String amount = amountPart.replaceAll("[^0-9]", "");
            total += Integer.parseInt(amount);
        }
        return total;
    }

    public static void main(String[] args) {
        String input = "Logo Design - 3000 INR, Web Page - 4500 INR";
        try{
            String[] tasks = parseInvoice(input);
            System.out.println("Invoice Details:");
            for(String task : tasks) {
                System.out.println(task.trim());
            }
            System.out.println("Total Amount: " + getTotalAmount(tasks) + " INR");
        }catch (InvalidInvoiceFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
