public class CircularLL {
    Node head;
    Node tail;
    class Node{
        Node next;
        int val;

        Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    //insert at start
    void insert_start(int val){
        Node NewNode = new Node(val);
        if(head==null){
            head = NewNode;
            tail = head;
            NewNode.next = head;
        }
        else{
            NewNode.next = head;
            tail.next = NewNode;
            head = NewNode;
        }
    }

    //insert at end
    void insert_end(int val){
        Node NewNode = new Node(val);
        if(head==null){
            head = NewNode;
            tail = head;
            NewNode.next = head;
        }
        else{
            tail.next = NewNode;
            NewNode.next = head;
            tail = NewNode;
        }
    }

    //insert at mid (prev val given)
    void insert_mid(int pre_val, int val){
        if (head == null) {
            System.out.println("Error - List is empty");
            return;
        }

        Node NewNode = new Node(val);
        Node temp = head;

        while(temp!=tail && temp.val!=pre_val){
            temp=temp.next;
        }
        if(temp.val!=pre_val){
            System.out.println("Error - Previous value not found");
        }
        else{
            if(temp.val == pre_val && temp.val == tail.val){
                tail.next = NewNode;
                NewNode.next = head;
                tail = NewNode;
                return;
            }
            NewNode.next = temp.next;
            temp.next = NewNode;
        }
    }

    //delete at start
    void delete_start(){
        if(head==null){
            System.out.println("Error - List was empty");
        }
        else{
            if(head == tail){
                head = tail = null;
                System.out.println("List is empty now");
                return;
            }
            head = head.next;            
            tail.next = head;
        }
    }

    //delete at end
    void delete_end(){
        if(head==null){
            System.out.println("Error - List was empty");
        }
        else{
            if(head == tail){
                head = tail = null;
                System.out.println("List is empty now");
                return;
            }
            Node temp = head;
            while(temp.next!=tail){
                temp = temp.next;
            }
            tail = temp;
            tail.next = head;
        }
    }

    //delete at mid
    void delete_mid(int val){
        if (head == null) {
            System.out.println("Error - List was empty");
            return;
        }
        if(head == tail && head.val==val){
            head = tail = null;
            System.out.println("List is empty now");
            return;
        }
        if(head.val == val){
            head = head.next;            
            tail.next = head;
            return;
        }
        Node temp = head;
        while(temp != tail && temp.next.val != val){
            temp = temp.next;
        }
        if(temp.next.val!=val){
            System.out.println("Error - value not found that was to be deleted");
        }
        else{
            if(temp.next.val == val && temp.next.val == tail.val){
                tail = temp;
                tail.next = head;
                return;
            }
            temp.next = temp.next.next;
        }
    }

    //print
    void print(){
        if(head==null){
            System.out.println("List is empty man!!");
            return;
        }
        Node temp = head;
        do{
            System.out.print(temp.val + " ");
            temp=temp.next;
        }while(temp!=head);
        System.out.println();
    }

    //psvm
    public static void main(String[] args) {
        CircularLL obj = new CircularLL();
        obj.delete_start();
        obj.insert_end(10);
        obj.delete_mid(10);
        obj.print();
        obj.insert_mid(10, 20);
        obj.insert_start(30);
        obj.insert_end(40);
        obj.delete_start();
        obj.print();
        obj.delete_end();
        obj.delete_mid(20);
        obj.print();
    }
}
