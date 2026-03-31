package linkedlist;

import java.util.*;

class Item {
    String name;
    int id, qty;
    double price;
    Item next;

    Item(String name, int id, int qty, double price) {
        this.name = name;
        this.id = id;
        this.qty = qty;
        this.price = price;
    }
}

class Inventory {
    Item head = null;

    void addFirst(Item item) {
        item.next = head;
        head = item;
    }

    void addLast(Item item) {
        if (head == null) head = item;
        else {
            Item temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = item;
        }
    }

    void addAtPosition(Item item, int pos) {
        if (pos <= 1 || head == null) addFirst(item);
        else {
            Item temp = head;
            for (int i = 1; i < pos - 1 && temp.next != null; i++) temp = temp.next;
            item.next = temp.next;
            temp.next = item;
        }
    }

    void removeById(int id) {
        if (head == null) return;
        if (head.id == id) head = head.next;
        else {
            Item temp = head;
            while (temp.next != null && temp.next.id != id) temp = temp.next;
            if (temp.next != null) temp.next = temp.next.next;
        }
    }

    void updateQty(int id, int qty) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.qty = qty;
                return;
            }
            temp = temp.next;
        }
    }

    void searchById(int id) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id) {
                System.out.println(temp.name + " " + temp.id + " " + temp.qty + " " + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Not found");
    }

    void searchByName(String name) {
        Item temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println(temp.name + " " + temp.id + " " + temp.qty + " " + temp.price);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("Not found");
    }

    void totalValue() {
        double sum = 0;
        Item temp = head;
        while (temp != null) {
            sum += temp.qty * temp.price;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: " + sum);
    }

    Item mergeSort(Item node, String key, boolean asc) {
        if (node == null || node.next == null) return node;
        Item mid = getMid(node);
        Item right = mid.next;
        mid.next = null;
        return merge(mergeSort(node, key, asc), mergeSort(right, key, asc), key, asc);
    }

    Item getMid(Item head) {
        Item slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    Item merge(Item a, Item b, String key, boolean asc) {
        Item dummy = new Item("", 0, 0, 0), tail = dummy;
        while (a != null && b != null) {
            boolean cond = key.equals("name") ?
                (asc ? a.name.compareTo(b.name) <= 0 : a.name.compareTo(b.name) > 0) :
                (asc ? a.price <= b.price : a.price > b.price);

            if (cond) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        tail.next = (a != null) ? a : b;
        return dummy.next;
    }

    void sort(String key, boolean asc) {
        head = mergeSort(head, key, asc);
    }

    void display() {
        Item temp = head;
        while (temp != null) {
            System.out.println(temp.name + " " + temp.id + " " + temp.qty + " " + temp.price);
            temp = temp.next;
        }
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventory inv = new Inventory();

        while (true) {
            System.out.println("\n1.AddFirst \n2.AddLast \n3.AddAtPos \n4.Remove \n5.UpdateQty \n6.SearchID \n7.SearchName\n8.TotalValue \n9.SortByName \n10.SortByPrice \n11.Display \n0.Exit");
            int ch = sc.nextInt();
            if (ch == 0) break;

            switch (ch) {
                case 1, 2, 3 -> {
                    System.out.print("Name ID Qty Price: ");
                    String name = sc.next();
                    int id = sc.nextInt(), qty = sc.nextInt();
                    double price = sc.nextDouble();
                    Item item = new Item(name, id, qty, price);
                    if (ch == 1) inv.addFirst(item);
                    else if (ch == 2) inv.addLast(item);
                    else {
                        System.out.print("Position: ");
                        inv.addAtPosition(item, sc.nextInt());
                    }
                }
                case 4 -> { System.out.print("ID to remove: "); inv.removeById(sc.nextInt()); }
                case 5 -> { System.out.print("ID & New Qty: "); inv.updateQty(sc.nextInt(), sc.nextInt()); }
                case 6 -> { System.out.print("ID to search: "); inv.searchById(sc.nextInt()); }
                case 7 -> { System.out.print("Name to search: "); inv.searchByName(sc.next()); }
                case 8 -> inv.totalValue();
                case 9 -> { System.out.print("1.Asc 0.Desc: "); inv.sort("name", sc.nextInt() == 1); }
                case 10 -> { System.out.print("1.Asc 0.Desc: "); inv.sort("price", sc.nextInt() == 1); }
                case 11 -> inv.display();
            }
        }
        sc.close();
    }
}