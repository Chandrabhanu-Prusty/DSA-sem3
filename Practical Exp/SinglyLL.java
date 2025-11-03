class SinglyLL {
    Node head;
    Node tail;

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }
    //insert at start
    void insert_start(int val) {
        Node NewNode = new Node(val);

        if (head == null) {
            head = tail = NewNode;
            head.next = null;
            tail.next = null;
        } else {
            NewNode.next = head;
            head = NewNode;
        }
    }

    //insert at end
    void insert_end(int val) {
        Node NewNode = new Node(val);

        if (head == null) {
            head = tail = NewNode;
            // next is already null
        } else {
            tail.next = NewNode;
            tail = NewNode;
            tail.next = null;
        }
    }

    //insert at mid (insert after a given value)
    void insert_mid(int pre_val, int val) {
        Node NewNode = new Node(val);

        Node temp = head;
        // find the node with value == pre_val
        while (temp != null && temp.val != pre_val) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Error - Cannot insert the value as previous value is absent");
        } else {
            NewNode.next = temp.next;
            temp.next = NewNode;
            if (temp == tail) {
                tail = NewNode;
            }
        }
    }

    //delete at start
    void delete_start() {
        if (head == null) {
            System.out.println("Empty List");
        } else {
            head = head.next;
            if (head == null) {
                tail = null;
            }
        }
    }

    //delete at end
    void delete_end() {
        if (head == null) {
            System.out.println("Empty list");
        } else {
            // if only one node
            if (head.next == null) {
                head = null;
                tail = null;
                return;
            }
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
        }
    }

    //delete at mid (delete by value)
    void delete_mid(int val) {
        if (head == null) {
            System.out.println("Error - value not found");
            return;
        }
        // if the head is to be deleted
        if (head.val == val) {
            head = head.next;
            if (head == null) tail = null;
            return;
        }

        Node prev = head;
        while (prev.next != null && prev.next.val != val) {
            prev = prev.next;
        }
        if (prev.next == null) {
            System.out.println("Error - value not found");
        } else {
            // delete prev.next
            prev.next = prev.next.next;
            if (prev.next == null) {
                tail = prev;
            }
        }
    }

    //print
    void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SinglyLL obj = new SinglyLL();
        obj.insert_end(5);
        obj.insert_start(10);
        obj.insert_start(20);
        obj.insert_start(30);
        obj.insert_end(35);
        obj.delete_end();
        obj.delete_start();
        obj.insert_mid(10, 40);
        obj.delete_mid(10);
        obj.print();

    }

}
