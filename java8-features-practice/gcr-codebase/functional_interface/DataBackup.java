package functional_interface;

interface BackupSerializable {
    
}

class UserData implements BackupSerializable {

    private String username;
    private int userId;

    UserData(String username, int userId) {
        this.username = username;
        this.userId = userId;
    }

    public String toString() {
        return "UserData [username: " + username + ", userId: " + userId + "]";
    }
}

class TempCache { 
    String cacheData = "Temporary data";
}

class BackupProcessor {

    static void processBackup(Object obj) {

        if (obj instanceof BackupSerializable) {
            System.out.println("Backing up object: " + obj);
        } else {
            System.out.println("Object is NOT eligible for backup");
        }
    }
}

public class DataBackup {

    public static void main(String[] args) {

        UserData user = new UserData("Harshita", 101);
        TempCache cache = new TempCache();

        BackupProcessor.processBackup(user);
        BackupProcessor.processBackup(cache);
    }
}