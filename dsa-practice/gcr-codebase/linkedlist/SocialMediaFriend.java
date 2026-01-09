package linkedlist;
import java.util.Scanner;

class Friend{
	int friendID;
    Friend next;

    Friend(int id) {
        this.friendID = id;
        this.next = null;
    }
}

class User {
    int userID;
    String name;
    int age;
    Friend friendList;
    User next;

    User(int userID, String name, int age) {
        this.userID = userID;
        this.name = name;
        this.age = age;
        this.friendList = null;
        this.next = null;
    }
}

class SocialMedia {
    User head = null;

    User findUser(int id) {
        User temp = head;
        while(temp != null) {
            if(temp.userID == id) {
            	return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    void addUser(int id, String name, int age) {
        User newUser = new User(id, name, age);
        if(head == null) {
        	head = newUser;
        }else {
            User temp = head;
            while(temp.next != null) {
            	temp = temp.next;
            }
            temp.next = newUser;
        }
    }

    void addFriend(int uid1, int uid2) {
        User u1 = findUser(uid1);
        User u2 = findUser(uid2);
        if(u1 == null || u2 == null || uid1 == uid2) {
            System.out.println("Invalid user(s).");
            return;
        }
        if(!isFriend(u1.friendList, uid2)) {
        	u1.friendList = addToFriendList(u1.friendList, uid2);
        }
        if(!isFriend(u2.friendList, uid1)) {
        	u2.friendList = addToFriendList(u2.friendList, uid1);
        }
        System.out.println("Friend connection added.");
    }

    Friend addToFriendList(Friend head, int fid) {
        Friend newNode = new Friend(fid);
        newNode.next = head;
        return newNode;
    }

    boolean isFriend(Friend head, int fid) {
        while(head != null) {
            if(head.friendID == fid) {
            	return true;
            }
            head = head.next;
        }
        return false;
    }

    void removeFriend(int uid1, int uid2) {
        User u1 = findUser(uid1);
        User u2 = findUser(uid2);
        if(u1 == null || u2 == null) {
            System.out.println("Invalid user(s).");
            return;
        }
        u1.friendList = removeFromFriendList(u1.friendList, uid2);
        u2.friendList = removeFromFriendList(u2.friendList, uid1);
        System.out.println("Friend connection removed.");
    }

    Friend removeFromFriendList(Friend head, int fid) {
        if(head == null) {
        	return null;
        }
        if(head.friendID == fid) {
        	return head.next;
        }
        Friend curr = head;
        while(curr.next != null) {
            if (curr.next.friendID == fid) {
                curr.next = curr.next.next;
                return head;
            }
            curr = curr.next;
        }
        return head;
    }

    void displayFriends(int uid) {
        User u = findUser(uid);
        if(u == null) {
            System.out.println("User not found.");
            return;
        }
        System.out.print("Friends of " + u.name + ": ");
        Friend f = u.friendList;
        while(f != null) {
            User friend = findUser(f.friendID);
            if(friend != null) {
            	System.out.print(friend.name + " ");
            }
            f = f.next;
        }
        System.out.println();
    }

    void searchByID(int id) {
        User u = findUser(id);
        if(u == null) {
        	System.out.println("User not found.");
        }else {
        	System.out.println("Found: " + u.name + ", Age: " + u.age);
        }
    }

    void searchByName(String name) {
        User temp = head;
        while(temp != null) {
            if(temp.name.equalsIgnoreCase(name)) {
                System.out.println("Found: " + temp.name + ", ID: " + temp.userID);
                return;
            }
            temp = temp.next;
        }
        System.out.println("User not found.");
    }

    void countFriends() {
        User temp = head;
        while(temp != null) {
            int count = 0;
            Friend f = temp.friendList;
            while(f != null) {
                count++;
                f = f.next;
            }
            System.out.println(temp.name + " has " + count + " friend(s).");
            temp = temp.next;
        }
    }

    void mutualFriends(int id1, int id2) {
        User u1 = findUser(id1);
        User u2 = findUser(id2);
        if(u1 == null || u2 == null) {
            System.out.println("Invalid user(s).");
            return;
        }
        System.out.print("Mutual friends: ");
        Friend f1 = u1.friendList;
        while(f1 != null) {
            if(isFriend(u2.friendList, f1.friendID)) {
                User mf = findUser(f1.friendID);
                if(mf != null) System.out.print(mf.name + " ");
            }
            f1 = f1.next;
        }
        System.out.println();
    }
}

public class SocialMediaFriend {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SocialMedia sm = new SocialMedia();
        while(true) {
            System.out.println("\n1.AddUser \n2.AddFriend \n3.RemoveFriend \n4.DisplayFriends");
            System.out.println("5.SearchByID \n6.SearchByName \n7.MutualFriends \n8.CountFriends \n0.Exit");
            int ch = sc.nextInt(); sc.nextLine();
            if(ch == 0) {
            	break;
            }
            switch(ch) {
                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Age: ");
                    int age = sc.nextInt(); sc.nextLine();
                    sm.addUser(id, name, age);
                    break;
                case 2:
                    System.out.print("User 1 ID: ");
                    int id1 = sc.nextInt();
                    System.out.print("User 2 ID: ");
                    int id2 = sc.nextInt(); sc.nextLine();
                    sm.addFriend(id1, id2);
                    break;
                case 3:
                    System.out.print("User 1 ID: ");
                    id1 = sc.nextInt();
                    System.out.print("User 2 ID: ");
                    id2 = sc.nextInt(); sc.nextLine();
                    sm.removeFriend(id1, id2);
                    break;
                case 4:
                    System.out.print("User ID: ");
                    id = sc.nextInt(); sc.nextLine();
                    sm.displayFriends(id);
                    break;
                case 5:
                    System.out.print("User ID: ");
                    id = sc.nextInt(); sc.nextLine();
                    sm.searchByID(id);
                    break;
                case 6:
                    System.out.print("User Name: ");
                    name = sc.nextLine();
                    sm.searchByName(name);
                    break;
                case 7:
                    System.out.print("User 1 ID: ");
                    id1 = sc.nextInt();
                    System.out.print("User 2 ID: ");
                    id2 = sc.nextInt(); sc.nextLine();
                    sm.mutualFriends(id1, id2);
                    break;
                case 8:
                    sm.countFriends();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}