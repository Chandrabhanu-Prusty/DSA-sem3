public class Queue {
    int[] arr;
    int front;
    int rear;
    int capacity;

    Queue(int capacity){
        this.capacity = capacity;
        arr = new int[capacity];
        this.front = -1;
        this.rear = -1;
    }

    //insert
    void insert(int element){
        if(rear > capacity -1 && front ==0){
            System.out.println("Queue is full");
        }
        else{
            if(front==-1){
                front++;
                rear++;
                arr[rear] = element;
            }
            else{
                rear++;
                arr[rear] = element;
            }
        }
    }

    //delete
    int delete(){
        if((front==-1 && rear ==-1)||(front>rear)){
            System.out.println("Queue is empty");
        }
        else{
            return arr[front++];
        }
        return 0;
    }

    //print
    void print(){
        for (int i = front; i<=rear; i++) {
            System.out.println("Element at position "  +  i + " is " + arr[i]);
        }
    }
}

class QueueOP{
    public static void main(String[] args) {
        Queue q1 = new Queue(5);
        q1.insert(10);
        q1.insert(20);
        q1.insert(30);
        q1.print();
        int val = q1.delete();
        System.out.println("Removed element: "+val);
        q1.insert(40);
        q1.print();
    }
}
