public class QueueADT {

    int size;
    int[] arr;
    int front;
    int rear;

    public QueueADT(int size) {
        this.size = size;
        front = rear = -1;
        arr = new int[size];
    }

    //enqueue
    void enqueue(int element) {
        // simple non-circular queue: when rear reaches last index, it's full
        if (rear >= size - 1) {
            System.out.println("Queue overflow");
            return;
        }

        if (front == -1) {
            // first element
            front = 0;
            rear = 0;
            arr[rear] = element;
        } else {
            rear++;
            arr[rear] = element;
        }
    }

    //dequeue
    int dequeue() {
        if (front == -1 || front > rear) {
            System.out.println("Queue is empty");
        }
        else{
            return arr[front++];
        }
        return 0;
    }

    void print(){
        for (int i = front; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueADT q1 = new QueueADT(5);
        q1.enqueue(10);
        q1.enqueue(20);
        q1.enqueue(30);
        q1.enqueue(40);
        q1.enqueue(50);
        q1.print();
        q1.dequeue();
        q1.print();
    }
}

