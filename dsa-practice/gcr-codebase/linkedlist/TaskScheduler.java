package linkedlist;

import java.util.Scanner;

class Task {
    int id;
    String name;
    int priority;
    String dueDate;
    Task next;

    public Task(int id, String name, int priority, String dueDate) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class CircularTaskList {
    Task head = null;
    Task tail = null;
    Task current = null;

    public void addAtBeginning(Task newTask) {
        if (head == null) {
            head = tail = current = newTask;
            newTask.next = head;
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head;
        }
    }

    public void addAtEnd(Task newTask) {
        if (head == null) {
            head = tail = current = newTask;
            newTask.next = head;
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head;
        }
    }

    public void addAtPosition(Task newTask, int position) {
        if (head == null || position <= 1) {
            addAtBeginning(newTask);
            return;
        }

        Task temp = head;
        int i = 1;
        while (i < position - 1 && temp.next != head) {
            temp = temp.next;
            i++;
        }

        newTask.next = temp.next;
        temp.next = newTask;

        if (temp == tail) {
            tail = newTask;
        }
    }

    public void removeById(int id) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        if (head.id == id) {
            if (head == tail) {
                head = tail = current = null;
            } else {
                head = head.next;
                tail.next = head;
                if (current.id == id) current = head;
            }
            System.out.println("Task removed.");
            return;
        }

        Task prev = head;
        Task temp = head.next;

        while (temp != head) {
            if (temp.id == id) {
                prev.next = temp.next;
                if (temp == tail) {
                    tail = prev;
                }
                if (current == temp) current = head;
                System.out.println("Task removed.");
                return;
            }
            prev = temp;
            temp = temp.next;
        }

        System.out.println("Task not found.");
    }

    public void viewCurrentTask() {
        if (current == null) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("Current Task: ID=" + current.id + ", Name=" + current.name + ", Priority=" + current.priority + ", Due=" + current.dueDate);
        }
    }

    public void moveToNextTask() {
        if (current != null) {
            current = current.next;
            viewCurrentTask();
        } else {
            System.out.println("No tasks available.");
        }
    }

    public void displayAllTasks() {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        Task temp = head;
        do {
            System.out.println("ID=" + temp.id + ", Name=" + temp.name + ", Priority=" + temp.priority + ", Due=" + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        Task temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println("Found: ID=" + temp.id + ", Name=" + temp.name + ", Due=" + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) System.out.println("No tasks with priority " + priority);
    }
}

public class TaskScheduler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularTaskList taskList = new CircularTaskList();
        int choice;

        do {
            System.out.println("\nTask Scheduler");
            System.out.println("1. Add Task at Beginning");
            System.out.println("2. Add Task at End");
            System.out.println("3. Add Task at Position");
            System.out.println("4. Remove Task by ID");
            System.out.println("5. View Current Task");
            System.out.println("6. Move to Next Task");
            System.out.println("7. Display All Tasks");
            System.out.println("8. Search Task by Priority");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            int id, priority, position;
            String name, dueDate;

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Enter Task ID: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Task Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter Priority: ");
                    priority = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Due Date: ");
                    dueDate = sc.nextLine();
                    Task newTask = new Task(id, name, priority, dueDate);
                    if (choice == 1) taskList.addAtBeginning(newTask);
                    else if (choice == 2) taskList.addAtEnd(newTask);
                    else {
                        System.out.print("Enter Position: ");
                        position = sc.nextInt();
                        taskList.addAtPosition(newTask, position);
                    }
                    break;

                case 4:
                    System.out.print("Enter Task ID to remove: ");
                    id = sc.nextInt();
                    taskList.removeById(id);
                    break;

                case 5:
                    taskList.viewCurrentTask();
                    break;

                case 6:
                    taskList.moveToNextTask();
                    break;

                case 7:
                    taskList.displayAllTasks();
                    break;

                case 8:
                    System.out.print("Enter Priority to search: ");
                    priority = sc.nextInt();
                    taskList.searchByPriority(priority);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        sc.close();
    }
}