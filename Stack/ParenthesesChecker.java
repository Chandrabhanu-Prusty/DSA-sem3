public class ParenthesesChecker {
    String bracket;
    StackCopy stack;

    // Constructor
    ParenthesesChecker(String bracket) {
        this.bracket = bracket;
        this.stack = new StackCopy(bracket.length());
    }

    // Main function to check balanced parentheses
    boolean isBalanced() {
        for (int i = 0; i < bracket.length(); i++) {
            char ch = bracket.charAt(i);

            if (ch == '{' || ch == '(' || ch == '[') {
                stack.push(ch);
            } else if (ch == '}' || ch == ')' || ch == ']') {
                if (stack.isEmpty()) return false;

                char popped = stack.pop();
                if (!isMatching(popped, ch)) return false;
            }
        }
        return stack.isEmpty();
    }

    // Helper function to match pairs
    boolean isMatching(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }
}

class StackCopy {
    private char[] arr;
    private int top;
    private int capacity;

    public StackCopy(int capacity) {
        this.capacity = capacity;
        arr = new char[capacity];
        top = -1;
    }

    boolean isFull() {
        return top == capacity - 1;
    }

    boolean isEmpty() {
        return top == -1;
    }

    void push(char ch) {
        if (isFull()) {
            System.out.println("Stack is full");
        } else {
            arr[++top] = ch;
        }
    }

    char pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return '\0';
        } else {
            return arr[top--];
        }
    }
}

class Checker {
    public static void main(String[] args) {
        String expr = "{[()]}"; // Try changing to "{[(])}" or "((("

        ParenthesesChecker checker = new ParenthesesChecker(expr);
        if (checker.isBalanced()) {
            System.out.println("Parentheses are balanced!");
        } else {
            System.out.println("Parentheses are NOT balanced!");
        }
    }
}
