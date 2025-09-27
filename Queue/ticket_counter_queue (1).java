import java.util.*;

class QueueADT {
    int[] q;
    int front;
    int rear;
    int size;
    int capacity;

    public QueueADT(int cap) {
        this.capacity = cap;
        q = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int x) {
        if (isFull()) return;
        rear = (rear + 1) % capacity;
        q[rear] = x;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) return -1;
        int item = q[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}

class TicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ---- Input ----
        int n = sc.nextInt();             // number of people in queue
        int[] tickets = new int[n];
        for (int i = 0; i < n; i++) {
            tickets[i] = sc.nextInt();    // tickets needed for each person
        }

        // ---- Queue Simulation ----
        QueueADT queue = new QueueADT(10000);
        for (int i = 0; i < n; i++) {
            queue.enqueue(i); // enqueue people by index
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int idx = queue.dequeue();
            tickets[idx]--; 
            sb.append(idx).append(" ");   // person idx buys one ticket
            if (tickets[idx] > 0) {
                queue.enqueue(idx);       // if still need tickets → go back in queue
            }
        }

        // ---- Output ----
        System.out.println(sb.toString().trim());
    }
}
