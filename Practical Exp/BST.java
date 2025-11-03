class Node {
    int data;
    Node left, right;

    public Node(int value) {
        data = value;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    // Insert a node
    Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.data) {
            node.left = insert(node.left, value);
        } else if (value > node.data) {  // avoid duplicates
            node.right = insert(node.right, value);
        }
        return node;
    }

    // Wrapper method for easy use
    void insert(int value) {
        root = insert(root, value);
    }

    // Preorder - Root, Left, Right
    void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    // Inorder - Left, Root, Right
    void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    // Postorder - Left, Right, Root
    void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Insert sample values
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int v : values) {
            bst.insert(v);
        }

        // Display traversals
        System.out.print("Inorder traversal: ");
        bst.inorder(bst.root);
        System.out.println();

        System.out.print("Preorder traversal: ");
        bst.preorder(bst.root);
        System.out.println();

        System.out.print("Postorder traversal: ");
        bst.postorder(bst.root);
        System.out.println();
    }
}
