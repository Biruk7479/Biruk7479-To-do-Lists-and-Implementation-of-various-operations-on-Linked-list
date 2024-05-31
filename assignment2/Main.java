package assignment2;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    private Node head; // Reference to the first node in the list

    public LinkedList() {
        this.head = null; // Initialize an empty list
    }

    // Method to get the head of the list
    public Node getHead() {
        return head;
    }

    // Inserting a Node at a specified position in the list
    public void insertAtPos(int data, int position) {
        Node newNode = new Node(data);
        if (position <= 0) {
            System.out.println("Invalid position");
            return;
        }
        if (position == 1) { // Insert at the beginning
            newNode.next = head;
            head = newNode;
        } else { // Insert at a position other than the beginning
            Node temp = head;
            for (int i = 1; i < position - 1 && temp != null; i++) {
                temp = temp.next;
            }
            if (temp != null) {
                newNode.next = temp.next;
                temp.next = newNode;
            } else {
                System.out.println("Invalid position");
            }
        }
    }

    // Deleting a Node at a specified position in the list
    public void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (position == 1) { // Delete the first node
            head = head.next;
        } else { // Delete a node other than the first
            Node temp = head;
            for (int i = 1; i < position - 1 && temp != null; i++) {
                temp = temp.next;
            }
            if (temp != null && temp.next != null) {
                temp.next = temp.next.next;
            } else {
                System.out.println("Invalid position");
            }
        }
    }

    // Deleting a Node after a given Node in the list
    public void deleteAfterNode(Node prevNode) {
        if (prevNode == null || prevNode.next == null) {
            System.out.println("Previous node is null or last node");
            return;
        }
        prevNode.next = prevNode.next.next;
    }

    // Searching for a Node with a specific value in the list
    public boolean searchNode(int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) {
                return true; // Node found
            }
            temp = temp.next;
        }
        return false; // Node not found
    }

    // Printing the elements of the list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

class Stack {
    private LinkedList list;

    public Stack() {
        this.list = new LinkedList(); // Create a new LinkedList for the Stack
    }

    // Push operation to add an element to the top of the Stack
    public void push(int data) {
        list.insertAtPos(data, 1); // Insert at the beginning for stack behavior
    }

    // Pop operation to remove and return the top element from the Stack
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        int popped = list.getHead().data;
        list.deleteAtPosition(1); // Delete from the beginning for stack behavior
        return popped;
    }

    // Peek operation to return the top element of the Stack without removing it
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.getHead().data;
    }

    // Check if the Stack is empty
    public boolean isEmpty() {
        return list.getHead() == null;
    }

    // Print the elements of the Stack
    public void printStack() {
        list.printList();
    }
}

public class Main {
    public static void main(String[] args) {
        // Example usage of LinkedList operations
        LinkedList linkedList = new LinkedList();
        linkedList.insertAtPos(10, 1);
        linkedList.insertAtPos(20, 2);
        linkedList.insertAtPos(30, 3);
        linkedList.insertAtPos(40, 2);
        linkedList.printList(); // Output: 10 40 20 30
        linkedList.deleteAtPosition(3);
        linkedList.printList(); // Output: 10 40 30
        System.out.println("Search for 40: " + linkedList.searchNode(40)); // Output: true

        // Example usage of Stack implemented using LinkedList
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.printStack(); // Output: 30 20 10
        System.out.println("Peek: " + stack.peek()); // Output: 30
        System.out.println("Pop: " + stack.pop()); // Output: 30
        stack.printStack(); // Output: 20 10
    }
}
