public class circularQueue {
    int[] arr;
    int front;
    int rear;
    int size;

    public circularQueue(int size) {
        this.size = size;
        front=rear=-1;
        arr = new int[size];
    }

    //insert the element from rear
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % size;
        }
        arr[rear] = value;
        return true;
    }
    
    //delete the element from front
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % size;
        }
        return true;
    }

    //checks if the queue is empty or not
    public boolean isEmpty() {
        return front == -1;
    }
    
    //checks if the queue is full or not
    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        int temp = front;
        while (true) {
            System.out.print(arr[temp] + " -> ");
            if (temp == rear) break;  // stop after printing rear
            temp = (temp + 1) % size;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        circularQueue cq1 = new circularQueue(5);
        cq1.enQueue(10);
        cq1.enQueue(20);
        cq1.enQueue(30);
        cq1.enQueue(40);
        cq1.enQueue(50);
        cq1.enQueue(60);
        cq1.print();
        cq1.deQueue();
        cq1.print();
    }
    
}
