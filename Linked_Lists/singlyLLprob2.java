import java.util.*;

class Main2 {

    static class Node {

        String name;
        Node next;

        Node(String name) {
            this.name = name;
            this.next = null;
        }
    }

    static class ContactManager {

        Node head = null;
        Node tail = null;
        int size = 0;

        void add(String name) {
            Node newNode = new Node(name);
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            size++;
            System.out.println("Added contact " + name);
        }

        void remove(String name) {
            if (head == null) {
                System.out.println("Contact " + name + " not found");
                return;
            }
            if (head.name.equals(name)) {
                head = head.next;
                if (head == null) {
                    head = tail = null;
                }
                size--;
                System.out.println("Removed contact " + name);
                return;
            }
            Node temp = head;
            while (temp.next != null && !temp.name.equals(name)) {
                temp = temp.next;
            }
            if (temp.next == null) {
                System.out.println("Contact " + name + " not found");
            } else {
                if (temp.next == tail) {
                    tail = temp;
                }
                temp.next = temp.next.next;
                size--;
                System.out.println("Removed contact " + name);
            }
        }

        void display() {
            if (head == null) {
                System.out.println("Contact list is empty");
                return;
            }

            Node temp = head;
            while (temp != null) {
                System.out.print(temp.name);
                if (temp.next != null) {
                    System.out.print(" ");
                }
                temp = temp.next;
            }
            System.out.println();
        }

        void count() {
            System.out.println(size);
        }

        void search(String name) {
            Node temp = head;
            while (temp != null) {
                if (temp.name.equals(name)) {
                    System.out.println("Contact " + name + " found");
                    return;
                }
                temp = temp.next;
            }
            System.out.println("Contact " + name + " not found");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine()); // using parseInt

        ContactManager list = new ContactManager();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" "); // using split

            if (parts[0].equals("display")) {
                list.display();
            } else if (parts[0].equals("count")) {
                list.count();
            } else if (parts[0].equals("add")) {
                list.add(parts[1]);
            } else if (parts[0].equals("remove")) {
                list.remove(parts[1]);
            } else if (parts[0].equals("search")) {
                list.search(parts[1]);
            }
        }
    }
}
