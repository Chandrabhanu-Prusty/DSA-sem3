
public class Doubly_Linked_List {

    Node head;

    class Node {

        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
        }
    }

    public void inser_at_start(int val) {
        Node NewNode = new Node(val);
        NewNode.next = head;
        NewNode.prev = null;
        if (head != null) {
            head.prev = NewNode;
        }
        head = NewNode;
    }

    public void insert_at_end(int val) {
        Node NewNode = new Node(val);
        if (head == null) {
            inser_at_start(val);
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        NewNode.prev = temp;
        temp.next = NewNode;
        NewNode.next = null;
    }

    public void insert_at_mid(int after_val, int pre_val) {
        Node NewNode = new Node(after_val);
        if (head == null) {
            inser_at_start(pre_val);
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        if (temp.value == pre_val) {
            NewNode.prev = temp;
            temp.next = NewNode;
            NewNode.next = null;
            return;
        }
        Node current = head;
        while (current.value != pre_val) {
            current = current.next;
        }
        NewNode.next = current.next;
        NewNode.prev = current;
        current.next.prev = NewNode;
        current.next = NewNode;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void delete_at_start() {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }
        head = head.next;
        head.prev = null;
    }

    public void delete_at_end() {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        if (temp.prev != null) {
            temp.prev.next = null;
        } else {
            head = null; // If the list had only one element
        }
    }

    public int delete_at_mid(int val) {
        if (head == null) {
            System.out.println("List is empty");
            return -1;
        }
        Node temp = head;
        while (temp != null && temp.value != val) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Value not found");
            return -1;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        } else {
            head = temp.next; // If the node to delete is the head
        }
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
        return temp.value; // Return the deleted value
    }

    public int search(int value) {
        Node temp = head;
        while (temp != null) {
            if (temp.value == value) {
                return value;
            }
            temp = temp.next;
        }
        return -1;
    }

    public static void main(String[] args) {
        Doubly_Linked_List list = new Doubly_Linked_List();
        list.inser_at_start(10);
        list.inser_at_start(20);
        list.inser_at_start(30);
        list.display();

        list.insert_at_end(40);
        list.insert_at_end(50);
        list.display();

        list.insert_at_mid(60, 20);
        list.display();

        list.delete_at_start();
        list.display();

        list.delete_at_end();
        list.display();

        list.delete_at_mid(60);
        list.display();

        int l = list.search(10);
        System.out.println(l);
    }
}
