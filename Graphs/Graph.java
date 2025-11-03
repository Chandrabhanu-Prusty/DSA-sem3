public class Graph {
    int vertices;
    MyLinkedList[] adjList;

    public Graph(int n) {
        vertices = n;
        adjList = new MyLinkedList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new MyLinkedList();
        }
    }

    // Add undirected edge u - v
    public void addEdge(int u, int v) {
        adjList[u].append(v);
        adjList[v].append(u);
    }

    // Remove undirected edge u - v
    public void removeEdge(int u, int v) {
        adjList[u].delete(v);
        adjList[v].delete(u);
    }

    // Print adjacency list representation
    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("Node " + i + " is connected to: ");
            adjList[i].printList();
            System.out.println();
        }
    }

    // BFS traversal starting from 'start'
    public void bfs(int start) {
        boolean[] visited = new boolean[vertices];
        MyQueue queue = new MyQueue();

        visited[start] = true;
        queue.enqueue(start);

        System.out.print("BFS: ");

        while (!queue.isEmpty()) {
            int node = queue.dequeue();
            System.out.print(node + " ");

            MyLinkedList.Node temp = adjList[node].head;
            while (temp != null) {
                int neighbor = temp.data;
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.enqueue(neighbor);
                }
                temp = temp.next;
            }
        }

        System.out.println();
    }

    // DFS traversal using stack starting from 'start'
    public void dfs(int start) {
        boolean[] visited = new boolean[vertices];
        MyStack stack = new MyStack();

        stack.push(start);

        System.out.print("DFS: ");

        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (!visited[node]) {
                visited[node] = true;
                System.out.print(node + " ");

                // Push neighbors in reverse order so they are processed in order
                MyLinkedList.Node temp = adjList[node].head;
                MyStack reverse = new MyStack();

                while (temp != null) {
                    if (!visited[temp.data]) {
                        reverse.push(temp.data);
                    }
                    temp = temp.next;
                }

                while (!reverse.isEmpty()) {
                    stack.push(reverse.pop());
                }
            }
        }

        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        Graph g = new Graph(6);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);

        g.printGraph();
        g.bfs(0);
        g.dfs(0);
    }
}
