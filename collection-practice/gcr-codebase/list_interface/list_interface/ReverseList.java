package list_interface;
import java.util.*;

public class ReverseList {

    // By (ArrayList)
    public static List<Integer> reverseArrayList(List<Integer> list) {
        int left = 0;
        int right = list.size() - 1;
        while(left < right) {
            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
        return list;
    }

    // By (LinkedList)
    public static List<Integer> reverseLinkedList(LinkedList<Integer> list) {
        int left = 0;
        int right = list.size() - 1;
        while(left < right) {
            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("Reversed ArrayList: " + reverseArrayList(arrList));
        LinkedList<Integer> linkList = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("Reversed LinkedList: " + reverseLinkedList(linkList));

    }
}
