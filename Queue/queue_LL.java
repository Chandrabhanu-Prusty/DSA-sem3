// Node class
class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Linear Queue using Linked List
class LinearQueue{
    private Node front, rear;

    LinearQueue() {
        front = rear = null;
    }

    // Check if queue is empty
    boolean isEmpty() {
        return front == null;
    }

    // Enqueue
    void enqueue(int x) {
        Node newNode = new Node(x);
        if (rear == null) { // first element
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println(x + " enqueued");
    }

    // Dequeue
    int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }
        int val = front.data;
        front = front.next;
        if (front == null) rear = null; // queue empty
        return val;
    }

    // Peek front
    int peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return front.data;
    }

    // Print queue
    void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
        Node temp = front;
        System.out.print("Queue: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

// Demo
class LinearQueueDemo{
    public static void main(String[] args) {
        LinearQueue q = new LinearQueue();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        q.printQueue(); // 10 20 30

        System.out.println("Dequeued: " + q.dequeue()); // 10
        q.printQueue(); // 20 30
    }
}
