package assignment1;
import java.util.Scanner;

// Task class represents a single task with a title, description, and completion status
class Task {
    private String title;
    private String description;
    private boolean completed;

    // Constructor to initialize a task with a title and description, initially not completed
    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false;
    }

    // Getter methods for task properties
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    // Method to mark a task as completed
    public void markCompleted() {
        this.completed = true;
    }
}

// Node class represents a node in a linked list, containing a task and a reference to the next node
class Node {
    private Task task;
    private Node next;

    // Constructor to initialize a node with a task
    public Node(Task task) {
        this.task = task;
        this.next = null;
    }

    // Getter and setter methods for node properties
    public Task getTask() {
        return task;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

// ToDoList class represents a list of tasks using a linked list
class ToDoList {
    private Node head;

    // Method to add a task to the to-do list
    public void addToDo(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    // Method to mark a task as completed given its title
    public void markToDoAsCompleted(String title) {
        Node current = head;
        while (current != null) {
            Task task = current.getTask();
            if (task.getTitle().equals(title)) {
                task.markCompleted();
                break;
            }
            current = current.getNext();
        }
    }

    // Method to display the to-do list with task details
    public void viewToDoList() {
        Node current = head;
        System.out.println("To-Do List:");
        while (current != null) {
            Task task = current.getTask();
            System.out.println("Title: " + task.getTitle());
            System.out.println("Description: " + task.getDescription());
            System.out.println("Completed: " + task.isCompleted());
            System.out.println();
            current = current.getNext();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList(); // Create a new to-do list
        Scanner scanner = new Scanner(System.in); // Initialize scanner for user input

        boolean exit = false;
        while (!exit) {
            // Display menu options
            System.out.println("\n1. Add Task");
            System.out.println("2. Mark Task as Completed");
            System.out.println("3. View To-Do List");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt(); // Read user choice
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1: // Add Task
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    toDoList.addToDo(new Task(title, description)); // Add task to the list
                    System.out.println("\nTask added successfully!");
                    break;
                case 2: // Mark Task as Completed
                    System.out.print("Enter task title to mark as completed: ");
                    String titleToMark = scanner.nextLine();
                    toDoList.markToDoAsCompleted(titleToMark); // Mark task as completed
                    System.out.println("\nTask marked as completed!");
                    break;
                case 3: // View To-Do List
                    toDoList.viewToDoList(); // Display the to-do list
                    System.out.println("\nPress Enter to continue...");
                    scanner.nextLine(); // Wait for user to press Enter before continuing
                    break;
                case 4: // Exit
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default: // Invalid choice
                    System.out.println("\nInvalid choice!");
                    break;
            }
        }

        scanner.close(); // Close the scanner
    }
}
