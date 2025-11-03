class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

class BFS {
    Node root;

    Node insert(Node node, int value) {
        if (node == null){
            return new Node(value);
        }
        if (value < node.data){
            node.left = insert(node.left, value);
        }
        else if (value > node.data){
            node.right = insert(node.right, value);
        }
        return node;
    }

    void insert(int value) {
        root = insert(root, value);
    }

    // Simple BFS using array as queue
    void bfs(Node root) {
        if (root == null) return;

        Node[] queue = new Node[100]; // fixed-size simple queue
        int front = 0, rear = 0;

        queue[rear++] = root;

        while (front < rear) {
            Node current = queue[front++];
            System.out.print(current.data + " ");

            if (current.left != null)
                queue[rear++] = current.left;
            if (current.right != null)
                queue[rear++] = current.right;
        }
    }

    public static void main(String[] args) {
        BFS obj = new BFS();

        int[] values = {50, 30, 70, 20, 60, 40, 80};
        for (int v : values)
            obj.insert(v);

        System.out.print("Level Order (BFS): ");
        obj.bfs(obj.root);
    }
}
