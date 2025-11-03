public class StackLL {
    Node top;

    class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    //push (insert at start)
    void push(int val){
        Node NewNode = new Node(val);
        if(top==null){
            top = NewNode;
            top.next = null;
        }
        else{
            NewNode.next = top;
            top = NewNode;
        }
    }

    //pop (delete at start)
    void pop(){
        if(top==null){
            System.out.println("Error - Stack Underflow");
        }
        else{
            System.out.println("Popped value: " + top.val);
            top = top.next;
        }
    }

    //peek (return top)
    void peek(){
        if(top==null){
            System.out.println("Error - Stack Underflow");
        }
        else{
            System.out.println("Top most element: " + top.val);
        }
    }

    //print
    void print(){
        if(top==null){
            System.out.println("Error - Stack Underflow");
        }
        else{
            Node temp = top;
            while(temp!=null){
                System.out.println(temp.val);
                temp = temp.next;
            }
            System.out.println();
        }
    }

    //psvm
    public static void main(String[] args) {
        StackLL s1 = new StackLL();
        s1.push(10);
        s1.push(20);
        s1.push(30);
        s1.print();
        s1.peek();
        s1.pop();
        s1.print();
    }
}
