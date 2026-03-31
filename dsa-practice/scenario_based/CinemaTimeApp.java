package scenario_based;
import java.util.ArrayList;
import java.util.List;

class InvalidTimeFormatException extends Exception {
    public InvalidTimeFormatException(String message) {
        super(message);
    }
}

class CinemaTime {
    private List<String> movieTitles;
    private List<String> showTimes;

    public CinemaTime() {
        movieTitles = new ArrayList<>();
        showTimes = new ArrayList<>();
    }

    public void addMovie(String title, String time) throws InvalidTimeFormatException {
        if(!isValidTime(time)) {
            throw new InvalidTimeFormatException("Invalid time format: " + time);
        }
        movieTitles.add(title);
        showTimes.add(time);
    }

    public void searchMovie(String keyword) {
        boolean found = false;
        try {
            for(int i = 0; i < movieTitles.size(); i++) {
                if(movieTitles.get(i).toLowerCase().contains(keyword.toLowerCase())) {
                    System.out.println(
                        String.format("Found: %s at %s", movieTitles.get(i), showTimes.get(i))
                    );
                    found = true;
                }
            }
            if(!found) {
                System.out.println("No movie found with keyword: " + keyword);
            }
        }catch(IndexOutOfBoundsException e) {
            System.out.println("Search index error occurred.");
        }
    }

    public void displayAllMovies() {
        if(movieTitles.isEmpty()) {
            System.out.println("No movies scheduled.");
            return;
        }
        for(int i = 0; i < movieTitles.size(); i++) {
            System.out.println(
                String.format("Movie: %s | Time: %s", movieTitles.get(i), showTimes.get(i))
            );
        }
    }

    public void generateReport() {
        String[] titlesArray = movieTitles.toArray(new String[0]);
        String[] timesArray = showTimes.toArray(new String[0]);
        System.out.println("\nPrintable Movie Report");
        for(int i = 0; i < titlesArray.length; i++) {
            System.out.println(titlesArray[i] + " - " + timesArray[i]);
        }
    }

    private boolean isValidTime(String time) {
        if(!time.matches("\\d{2}:\\d{2}")) {
            return false;
        }
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        return hour >= 0 && hour < 24 && minute >= 0 && minute < 60;
    }
}

public class CinemaTimeApp {
    public static void main(String[] args) {
        CinemaTime cinema = new CinemaTime();
        try {
            cinema.addMovie("Inception", "18:30");
            cinema.addMovie("Interstellar", "21:00");
            cinema.addMovie("Avatar", "25:99"); 
        } catch (InvalidTimeFormatException e) {
            System.out.println(e.getMessage());
        }
        cinema.displayAllMovies();
        cinema.searchMovie("inter");
        cinema.generateReport();
    }
}
