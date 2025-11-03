public class BinarySearchTreeTraversal {

    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    Node root;

    public BinarySearchTreeTraversal() {
        root = null;
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else { 
            root.right = insertRec(root.right, data);
        }
        
        return root;
    }

    public void inorder() {
        System.out.print("Inorder Traversal: ");
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);       
            System.out.print(root.data + " "); 
            inorderRec(root.right);      
        }
    }

    public void preorder() {
        System.out.print("Preorder Traversal: ");
        preorderRec(root);
        System.out.println();
    }

    private void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.data + " "); 
            preorderRec(root.left);      
            preorderRec(root.right);     
        }
    }

    public void postorder() {
        System.out.print("Postorder Traversal: ");
        postorderRec(root);
        System.out.println();
    }

    private void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);     
            postorderRec(root.right);    
            System.out.print(root.data + " "); 
        }
    }
    
    public static void main(String[] args) {
        BinarySearchTreeTraversal bst = new BinarySearchTreeTraversal();

        int[] elements = {43, 10, 79, 9, 12, 54, 90, 11, 50};
        
        System.out.println("Building Binary Search Tree");
        System.out.print("Inserting elements: ");
        for (int element : elements) {
            bst.insert(element);
            System.out.print(element + " ");
        }
        System.out.println("\n");
        
        System.out.println("Recursive Traversal Results");
        bst.inorder();
        bst.preorder();
        bst.postorder();
    }
}
