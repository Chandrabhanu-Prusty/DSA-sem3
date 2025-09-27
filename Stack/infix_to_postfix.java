
import java.util.*;

class StackADT {

    private char[] arr;
    private int top;
    private int capacity;

    public StackADT(int size) {
        capacity = size;
        arr = new char[capacity];
        top = -1;
    }

    public void push(char x) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = x;
    }

    public char pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return '\0';
        }
        return arr[top--];
    }

    public char peek() {
        if (!isEmpty()) {
            return arr[top];
        }
        return '\0';
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

class InfixToPostfix {

    // precedence of operators
    static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    // convert infix to postfix
    static String infixToPostfix(String exp) {
        String result = "";
        StackADT stack = new StackADT(exp.length());

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            // if operand, add to result
            if (Character.isLetterOrDigit(c)) {
                result += c;
            } // if '(', push to stack
            else if (c == '(') {
                stack.push(c);
            } // if ')', pop until '('
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.pop();
                }
                stack.pop(); // remove '(' from stack
            } // if operator
            else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result += stack.pop();
                }
                stack.push(c);
            }
        }

        // pop all remaining operators
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter infix expression: ");
        String exp = sc.nextLine();

        String postfix = infixToPostfix(exp);
        System.out.println("Postfix expression: " + postfix);
    }
}
