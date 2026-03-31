package scenario_based;
import java.util.*;

class InvalidBackupPathException extends Exception {
    public InvalidBackupPathException(String message) {
        super(message);
    }
}

class BackupTask implements Comparable<BackupTask> {
    String folderPath;
    int priority; 

    public BackupTask(String folderPath, int priority) throws InvalidBackupPathException {
        if(folderPath == null || folderPath.isEmpty()) {
           throw new InvalidBackupPathException("Invalid backup path!");
        }
        this.folderPath = folderPath;
        this.priority = priority;
    }

    @Override
    public int compareTo(BackupTask other) {
        return Integer.compare(other.priority, this.priority); 
    }
}

class BackupScheduler {
    PriorityQueue<BackupTask> queue = new PriorityQueue<>();

    public void addTask(BackupTask task) {
        queue.add(task);
    }

    public void executeBackups() {
        System.out.println("Executing backup tasks");
        while(!queue.isEmpty()) {
            BackupTask task = queue.poll();
            System.out.println("Backing up: " + task.folderPath +" | Priority: " + task.priority);
        }
    }
}

public class FileBackUpScheduler {
    public static void main(String[] args) {
        BackupScheduler scheduler = new BackupScheduler();
        try {
           scheduler.addTask(new BackupTask("/system/config", 5));
           scheduler.addTask(new BackupTask("/user/documents", 2));
           scheduler.addTask(new BackupTask("/database", 10));
     }catch(InvalidBackupPathException e) {
          System.out.println(e.getMessage());
     }
     scheduler.executeBackups();
   }
}
