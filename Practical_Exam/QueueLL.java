public class QueueLL {
    Node front;
    Node rear;

    class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    //enqueue (input from rear --> insert at end <rear is like tail>)
    void enqueue(int val){
        Node NewNode = new Node(val);
        if(rear==null){
            front = rear = NewNode;
        }
        else{
            rear.next = NewNode;
            rear = NewNode;
        }
    }

    //dequeue (delete at start)
    void dequeue(){
        if(front==null){
            System.out.println("Queue Underflow");
        }
        else{
            front = front.next;
            if (front == null){
                rear = null;
            }
        }
    }

    //print
    void print(){
        if(front==null){
            System.out.println("Queue is empty");
        }
        else{
            Node temp = front;
            do { 
                System.out.println(temp.val + " ");
                temp = temp.next;
            } while (temp!=null);
        }
    }

    //psvm
    public static void main(String[] args) {
        QueueLL q1 = new QueueLL();
        q1.enqueue(10);
        q1.enqueue(20);
        q1.enqueue(30);
        q1.enqueue(40);
        q1.dequeue();
        q1.print();
    }
}
