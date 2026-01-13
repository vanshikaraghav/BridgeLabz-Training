package library_system;

public class Member extends User implements FineCalculator {
    String type;

    Member(int id, String name, String type) {
        super(id, name);
        this.type = type;
    }

    public double calculateFine(int daysLate) {
        return type.equalsIgnoreCase("Student") ? daysLate * 2 : daysLate * 5;
    }
}
