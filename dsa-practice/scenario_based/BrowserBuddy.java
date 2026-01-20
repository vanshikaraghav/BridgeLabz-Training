package scenario_based;
import java.util.*;

//Doubly Linked List Node
class HistoryNode {
	String url;
    HistoryNode prev;
    HistoryNode next;

    HistoryNode(String url) {
    	this.url = url;
        this.prev = null;
        this.next = null;
    }
}

//Tab with browsing history
class Tab {
	HistoryNode current;

    public void visit(String url) {
    	HistoryNode newNode = new HistoryNode(url);
        if(current != null) {
           current.next = newNode;
           newNode.prev = current;
     }
     current = newNode;
     System.out.println("Visited: " + url);
    }

     // Back navigation
     public void back() {
         if(current == null || current.prev == null) {
            System.out.println("No page to go back");
            return;
     }
     current = current.prev;
     System.out.println("Back to: " + current.url);
     }

     // Forward navigation
     public void forward() {
         if(current == null || current.next == null) {
            System.out.println("No page to go forward");
            return;
     }
     current = current.next;
     System.out.println("Forward to: " + current.url);
     }

     public String getCurrentPage() {
         return current != null ? current.url : "No page";
     }
}

//Browser Manager
public class BrowserBuddy {
	static Stack<Tab> closedTabs = new Stack<>();
	static Tab currentTab = new Tab();

    // Close current tab
    public static void closeTab() {
        closedTabs.push(currentTab);
        currentTab = new Tab();
        System.out.println("Tab closed");
    }

    // Restore last closed tab
    public static void restoreTab() {
        if(closedTabs.isEmpty()) {
           System.out.println("No tabs to restore");
           return;
     }
     currentTab = closedTabs.pop();
     System.out.println("Tab restored, current page: " + currentTab.getCurrentPage());
    }

    public static void main(String[] args) {
        currentTab.visit("google.com");
        currentTab.visit("github.com");
        currentTab.visit("stackoverflow.com");
        currentTab.back();
        currentTab.back();
        currentTab.forward();
     closeTab();
     restoreTab();
    }
}
