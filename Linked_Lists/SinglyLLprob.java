import java.util.*;

class Main1{

    static class name {

        int id;
        name next;

        name(int id) {
            this.id = id;
            this.next = null;
        }
    }

    static class StudentList {

        name head = null;
        name tail = null;
        int size = 0;

        void add(int id) {
            name newNode = new name(id);
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            size++;
            System.out.println("Added student " + id);
        }

        void remove(int id) {
            if (head == null) {
                System.out.println("Student" + id + " not found");
                return;
            }
            if (head.id == id) {
                head = head.next;
                if (head == null) {
                    tail = null;
                }
                size--;
                System.out.println("Removed student " + id);
                return;
            }
            name curr = head;
            while (curr.next != null && curr.next.id != id) {
                curr = curr.next;
            }
            if (curr.next == null) {
                System.out.println("Student" + id + " not found");
            } else {
                if (curr.next == tail) {
                    tail = curr;
                }
                curr.next = curr.next.next;
                size--;
                System.out.println("Removed student " + id);
            }
        }

        void display() {
            if (head == null) {
                System.out.println("List is empty");
                return;
            }
            name curr = head;
            while (curr != null) {
                System.out.print(curr.id + " ");
                curr = curr.next;
            }
            System.out.println();
        }

        void count() {
            System.out.println(size);
        }

        void search(int id) {
            name curr = head;
            while (curr != null) {
                if (curr.id == id) {
                    System.out.println("Student " + id + " found");
                    return;
                }
                curr = curr.next;
            }
            System.out.println("Student " + id + " not found");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        StudentList list = new StudentList();

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String[] parts = input.split(" ");
            String command = parts[0];

            switch (command) {
                case "add":
                    int idToAdd = Integer.parseInt(parts[1]);
                    list.add(idToAdd);
                    break;

                case "remove":
                    int idToRemove = Integer.parseInt(parts[1]);
                    list.remove(idToRemove);
                    break;

                case "display":
                    list.display();
                    break;

                case "count":
                    list.count();
                    break;

                case "search":
                    int idToSearch = Integer.parseInt(parts[1]);
                    list.search(idToSearch);
                    break;

                default:
                    System.out.println("Wrong command");
            }
        }
        sc.close();
    }
}
