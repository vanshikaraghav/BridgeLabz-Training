package scenario_based;

import java.util.*;


class CreatorStats {
    private String creatorName;
    private double[] weeklyLikes;

    public static List<CreatorStats> engagementBoard = new ArrayList<>();

    public CreatorStats(String creatorName, double[] weeklyLikes) {
        this.creatorName = creatorName;
        this.weeklyLikes = weeklyLikes;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public double[] getWeeklyLikes() {
        return weeklyLikes;
    }
}

public class Stream_Buzz {

    public void registerCreator(CreatorStats record) {
        CreatorStats.engagementBoard.add(record);
    }

    public Map<String, Integer> getTopPostCounts(List<CreatorStats> records, double likeThreshold) {
        Map<String, Integer> result = new HashMap<>();

        for (CreatorStats creator : records) {
            int count = 0;
            for (double likes : creator.getWeeklyLikes()) {
                if (likes >= likeThreshold) {
                    count++;
                }
            }
            if (count > 0) {
                result.put(creator.getCreatorName(), count);
            }
        }
        return result;
    }

    public double calculateAverageLikes() {
        double totalLikes = 0;
        int totalWeeks = 0;

        for (CreatorStats creator : CreatorStats.engagementBoard) {
            for (double likes : creator.getWeeklyLikes()) {
                totalLikes += likes;
                totalWeeks++;
            }
        }
        return totalWeeks == 0 ? 0 : totalLikes / totalWeeks;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Stream_Buzz program = new Stream_Buzz();

        while (true) {
            System.out.println("\n1. Register Creator");
            System.out.println("2. Show Top Posts");
            System.out.println("3. Calculate Average Likes");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    System.out.print("Enter Creator Name: ");
                    String name = sc.nextLine();

                    double[] likes = new double[4];
                    System.out.println("Enter weekly likes (Week 1 to 4):");
                    for (int i = 0; i < 4; i++) {
                        likes[i] = sc.nextDouble();
                    }

                    CreatorStats creator = new CreatorStats(name, likes);
                    program.registerCreator(creator);
                    System.out.println("Creator registered successfully");
                    break;

                case 2:
                    System.out.print("Enter like threshold: ");
                    double threshold = sc.nextDouble();

                    Map<String, Integer> topPosts =
                            program.getTopPostCounts(CreatorStats.engagementBoard, threshold);

                    if (topPosts.isEmpty()) {
                        System.out.println("No top-performing posts this week");
                    } else {
                        for (Map.Entry<String, Integer> entry : topPosts.entrySet()) {
                            System.out.println(entry.getKey() + " - " + entry.getValue());
                        }
                    }
                    break;

                case 3:
                    double avg = program.calculateAverageLikes();
                    System.out.printf("Overall average weekly likes: %.0f%n", avg);
                    break;

                case 4:
                    System.out.println("Logging off - Keep Creating with StreamBuzz!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
