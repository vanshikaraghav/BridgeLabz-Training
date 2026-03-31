package functional_interface;
interface ReportExporter {

	void exportToCSV();
	void exportToPDF();
	default void exportToJSON() {
		System.out.println("Exporting report in JSON format (default implementation)");
	}
}

class SalesReportExporter implements ReportExporter {

	public void exportToCSV() {
		System.out.println("Sales report exported to CSV");
	}

	public void exportToPDF() {
		System.out.println("Sales report exported to PDF");
	}
}

class InventoryReportExporter implements ReportExporter {

	public void exportToCSV() {
		System.out.println("Inventory report exported to CSV");
	}

	public void exportToPDF() {
		System.out.println("Inventory report exported to PDF");
	}

	 public void exportToJSON() {
		System.out.println("Inventory report exported to JSON with custom structure");
	}
}

public class DataExportFeature {

	public static void main(String[] args) {

		ReportExporter sales = new SalesReportExporter();
		ReportExporter inventory = new InventoryReportExporter();

		sales.exportToCSV();
		sales.exportToPDF();
		sales.exportToJSON();

		inventory.exportToCSV();
		inventory.exportToPDF();
		inventory.exportToJSON();
	}
}
