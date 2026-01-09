package linkedlist;
import java.util.Scanner;

class TextState {
    String content;
    TextState prev, next;

    TextState(String content) {
        this.content = content;
        this.prev = this.next = null;
    }
}

class TextEditor {
    private TextState head = null, tail = null, current = null;
    private int size = 0;
    private final int MAX_HISTORY = 10;

    public void type(String newContent) {
        TextState newState = new TextState(newContent);
        if(current != null && current.next != null) {
            current.next.prev = null;
            current.next = null;
        }
        if(current == null) {
            head = tail = current = newState;
        }else {
            current.next = newState;
            newState.prev = current;
            current = newState;
            tail = newState;
        }
        size++;
        if(size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void undo() {
        if(current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo done.");
        }else {
            System.out.println("No more undo available.");
        }
    }

    public void redo() {
        if(current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo done.");
        }else {
            System.out.println("No more redo available.");
        }
    }

    public void display() {
        if(current == null) {
            System.out.println("No text available.");
        }else {
            System.out.println("Current Text: " + current.content);
        }
    }
}

public class UndoRedoTextEditor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TextEditor editor = new TextEditor();
        while(true) {
            System.out.println("1.Type \n2.Undo \n3.Redo \n4.Display \n0.Exit");
            int ch = Integer.parseInt(sc.nextLine());
            if (ch == 0) break;
            switch(ch) {
                case 1:
                    System.out.print("Enter new text: ");
                    String text = sc.nextLine();
                    editor.type(text);
                    break;
                case 2:
                    editor.undo();
                    break;
                case 3:
                    editor.redo();
                    break;
                case 4:
                    editor.display();
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}