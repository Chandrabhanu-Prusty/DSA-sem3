
public class Singly_Linked_List {

    Node head;
    int size;

    public Singly_Linked_List() {
        this.size = 0;
        this.head = null;
    }

    class Node {

        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }

    }

    public void inser_at_start(int val) {
        Node NewNode = new Node(val);
        if (head == null) {
            head = NewNode;
            size++;
        } else {
            NewNode.next = head;
            head = NewNode;
            size++;
        }
    }

    public void insert_at_end(int val) {
        Node NewNode = new Node(val);
        if (head == null) {
            head = NewNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = NewNode;
        }
        size++;
    }

    public void insert_at_mid(int new_val, int pre_val) {
        Node NewNode = new Node(new_val);
        Node temp = head;

        if (temp == null) {
            System.out.println("List is empty, inserting at start.");
            inser_at_start(new_val);
            return;
        }

        while (temp != null && temp.value != pre_val) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Previous value not found");
            return;
        }

        NewNode.next = temp.next;
        temp.next = NewNode;

        size++;
    }

    public int delete_at_start() {
        int val = head.value;
        if (head == null) {
            size--;
            System.out.println("List is empty");
            return val;
        }
        head = head.next;
        size--;
        return val;
    }

    public int delete_at_end() {
        if (size <= 1) {
            return delete_at_start();
        }

        Node secondLast = get(size - 2);
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        int val = temp.value;
        temp = secondLast;
        temp.next = null;
        size--;
        return val;
    }

    public int delete_at_mid(int index) {
        if (head == null) {
            System.out.println("List is empty");
            return -1;
        }
        if (index == 0) {
            return delete_at_start();
        }
        if (index >= size - 1) {
            return delete_at_end();
        }

        Node prev = get(index - 1);
        int val = prev.next.value;
        prev.next = prev.next.next;
        size--;
        return val;
    }

    public Node get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public Node search_node(int value) {
        Node node = new Node(value);
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("End");
        // System.out.println(size);
    }

    public static void main(String[] args) {
        Singly_Linked_List list = new Singly_Linked_List();
        list.inser_at_start(3);
        list.inser_at_start(4);
        list.inser_at_start(5);
        list.inser_at_start(6);
        list.display();

        list.insert_at_end(10);
        list.insert_at_end(20);
        list.insert_at_end(30);
        list.display();

        list.insert_at_mid(100, 5);
        list.display();

        list.delete_at_start();
        list.display();

        list.delete_at_end();
        list.display();

        list.delete_at_mid(3);
        list.display();

        Node found = list.search_node(10);
        if (found != null) {
            System.out.println("Found node with value: " + found.value);
        } else {
            System.out.println("Not found!");
        }
    }
}
