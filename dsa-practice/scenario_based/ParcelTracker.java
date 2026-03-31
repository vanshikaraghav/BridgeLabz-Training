package scenario_based;

class ParcelStage {
    String stage;
    ParcelStage next;

    ParcelStage(String stage) {
        this.stage = stage;
        this.next = null;
    }
}

class ParcelTracker {
    ParcelStage head;

    void addStage(String stage) {
        ParcelStage newNode = new ParcelStage(stage);
        if(head == null) {
            head = newNode;
            return;
        }
        ParcelStage temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Insert checkpoint
    void insertCheckpoint(String afterStage, String newStage) {
        ParcelStage temp = head;
        while(temp != null && !temp.stage.equals(afterStage)) {
            temp = temp.next;
        }
        if(temp == null) {
            System.out.println("Stage not found. Parcel may be lost.");
            return;
        }
        ParcelStage checkpoint = new ParcelStage(newStage);
        checkpoint.next = temp.next;
        temp.next = checkpoint;
    }

    // Display
    void trackParcel() {
        if(head == null) {
            System.out.println("No parcel data available.");
            return;
        }
        ParcelStage temp = head;
        while(temp != null) {
            System.out.print(temp.stage + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public static void main(String[] args) {
        ParcelTracker tracker = new ParcelTracker();
        tracker.addStage("Packed");
        tracker.addStage("Shipped");
        tracker.addStage("In Transit");
        tracker.addStage("Delivered");
        System.out.println("Initial Tracking:");
        tracker.trackParcel();
        System.out.println("\nAdding Customs Check:");
        tracker.insertCheckpoint("Shipped", "Customs Clearance");
        tracker.trackParcel();
    }
}
