package list_interface;
import java.util.*;

public class FindNthElementFromEnd {
    public static String findNthFromEnd(LinkedList<String> list, int n) {
        Iterator<String> first = list.iterator();
        Iterator<String> second = list.iterator();
        for(int i=0;i<n;i++) {
            if(!first.hasNext()) {
                return "Invalid n";
            }
            first.next();
        }
        while(first.hasNext()) {
            first.next();
            second.next();
        }
        return second.next();
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        int n = 2;
        System.out.println(findNthFromEnd(list, n));
    }
}
