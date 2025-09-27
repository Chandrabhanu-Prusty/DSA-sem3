// Node class
class Node{
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Stack class using Linked List
class Stack{
    private Node top;

    Stack() {
        this.top = null;
    }

    // Check if stack is empty
    boolean isEmpty() {
        return top == null;
    }

    // Check if stack is full (not really applicable for LL)
    boolean isFull() {
        return false; // linked list grows until memory ends
    }

    // Push element onto stack
    void push(int x) {
        Node newNode = new Node(x);
        newNode.next = top;
        top = newNode;
        System.out.println(x + " pushed");
    }

    // Pop element from stack
    int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int popped = top.data;
        top = top.next;
        return popped;
    }

    // Peek top element
    int peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return top.data;
    }

    // Print stack
    void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return;
        }
        Node temp = top;
        System.out.print("Stack: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

// Demo
class StackDemo {
    public static void main(String[] args) {
        Stack s = new Stack();

        s.push(10);
        s.push(20);
        s.push(30);

        s.printStack(); // 30 20 10

        System.out.println("Top: " + s.peek()); // 30

        System.out.println("Popped: " + s.pop()); // 30
        s.printStack(); // 20 10

        System.out.println("Is Empty? " + s.isEmpty());
    }
}
