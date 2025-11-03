public class MyQueue {
    private Node front;
    private Node rear;

    public MyQueue() {
        front = rear = null;
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);

        if (rear == null) {
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }

        int value = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        return value;
    }

    public int peek() {
        if (isEmpty()) return -1;
        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }
}
