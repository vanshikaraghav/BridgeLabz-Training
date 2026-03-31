package stack_queue_hashmap;

class MyHashMap {
    private static class Node {
        int key, value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int SIZE = 10;
    private Node[] table = new Node[SIZE];

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = hash(key);
        Node head = table[index];

        while (head != null) {
            if(head.key == key) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        Node newNode = new Node(key, value);
        newNode.next = table[index];
        table[index] = newNode;
    }

    public int get(int key) {
        int index = hash(key);
        Node head = table[index];

        while(head != null) {
            if(head.key == key) {
            	return head.value;
            }
            head = head.next;
        }
        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        Node head = table[index];
        Node prev = null;
        while(head != null) {
            if(head.key == key) {
                if(prev == null) {
                    table[index] = head.next;
                }else {
                    prev.next = head.next;
                }
                return;
            }
            prev = head;
            head = head.next;
        }
    }
}

public class CustomHashMap {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1, 10);
        map.put(11, 20);
        map.put(2, 30);
        System.out.println(map.get(11));
        map.remove(11);
        System.out.println(map.get(11));
    }
}
