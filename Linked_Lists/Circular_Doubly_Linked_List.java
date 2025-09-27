
public class Circular_Doubly_Linked_List {

    Node head;
    Node tail;

    public class Node {

        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
        }
    }

    public Circular_Doubly_Linked_List() {
        this.head = null;
        this.tail = null;
    }

    public void insert(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
            head.next = tail;
            tail.prev = head;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = head;
            head.prev = newNode;
            tail = newNode;
        }
    }

    public void insert_at_mid(int after_val, int pre_val) {
        Node NewNode = new Node(after_val);
        if (head == null || tail.value == pre_val) {
            insert(after_val);
            return;
        }
        Node current = head;
        while (current.value != pre_val && current.next != head) {
            current = current.next;
        }
        if (current.value == pre_val) {
            NewNode.next = current.next;
            NewNode.prev = current;
            current.next.prev = NewNode;
            current.next = NewNode;
        } else {
            System.out.println("Previous value not found");
            return;
        }
    }

    public void delete_at_start() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        } else {
            tail.next = head.next;
            head.next.prev = tail;
            head = head.next;
        }
    }

    public void delete_at_end() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head.prev = tail.prev;
        tail.prev.next = head;
        tail = tail.prev;
    }

    public int delete_at_mid(int val) {
        Node temp = head;
        while (temp.next != head && temp.next.value != val) {
            temp = temp.next;
        }
        if (temp.next.value == val) {
            temp.next = temp.next.next;
            temp.next.next.prev = temp;
            return val;
        } else {
            System.out.println("Value not found");
            return -1;
        }
    }

    public int search(int value) {
        Node temp = head;
        while (temp.next != head) {
            if (temp.value == value) {
                return value;
            }
            temp = temp.next;
        }
        if (temp.value == value) {
            return value;
        }
        return -1;
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        do {
            System.out.print(current.value + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println("HEAD");

    }

    public static void main(String[] args) {
        Circular_Doubly_Linked_List list = new Circular_Doubly_Linked_List();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.display();

        list.insert_at_mid(5, 2);
        list.display();

        list.delete_at_start();;
        list.display();

        list.delete_at_end();
        list.display();

        list.delete_at_mid(5);
        list.display();

        int l = list.search(2);
        System.out.println(l);
    }
}
