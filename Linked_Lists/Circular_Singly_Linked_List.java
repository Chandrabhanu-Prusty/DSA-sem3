public class Circular_Singly_Linked_List {
    Node head;

    public class Node {

        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Circular_Singly_Linked_List() {
        this.head = null;
    }

    public void insert(int val) {
        Node NewNode = new Node(val);
        if (head == null) {
            head = NewNode;
            NewNode.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = NewNode;
            NewNode.next = head;
        }
    }

    public void insert_at_mid(int after_val, int pre_val) {
        Node NewNode = new Node(after_val);
        if (head == null) {
            insert(pre_val);
            return;
        }
        Node current = head;
        while (current.value != pre_val && current.next != head) {
            current = current.next;
        }
        if (current.value == pre_val) {
            NewNode.next = current.next;
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
        }
        Node temp = head;
        do {
            temp = temp.next;
        } while (temp.next != head);
        temp.next = head.next;
        head = head.next;
    }

    public void delete_at_end() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        do {
            temp = temp.next;
        } while (temp.next.next != head);
        temp.next = head;
    }

    public int delete_at_mid(int val) {
        Node temp = head;
        while (temp.next != head && temp.next.value != val) {
            temp = temp.next;
        }
        if (temp.next.value == val) {
            temp.next = temp.next.next;
            return val;
        } else {
            System.out.println("Value not found");
            return -1;
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("HEAD");
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

    public static void main(String[] args) {
        Circular_Singly_Linked_List list = new Circular_Singly_Linked_List();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(6);
        list.insert(7);
        list.display();

        list.insert_at_mid(5, 2);
        list.display();

        list.delete_at_start();
        list.display();
        list.delete_at_end();
        list.display();

        list.delete_at_mid(3);
        list.display();

        int l = list.search(5);
        System.out.println(l);
    }
}
