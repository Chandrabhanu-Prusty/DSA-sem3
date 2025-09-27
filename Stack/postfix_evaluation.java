import java.util.*;

class StackADT {
    int[] stack;
    int top;
    int capacity;

    public StackADT(int size) {
        stack = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int x) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        stack[++top] = x;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return stack[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

class PostfixEvaluation {

    public static int evaluatePostfix(String exp) {
        StackADT st = new StackADT(exp.length());

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            // If operand (number), push to stack
            if (Character.isDigit(c)) {
                st.push(c - '0');
            }
            // Operator
            else {
                int val2 = st.pop();
                int val1 = st.pop();

                switch (c) {
                    case '+':
                        st.push(val1 + val2);
                        break;
                    case '-':
                        st.push(val1 - val2);
                        break;
                    case '*':
                        st.push(val1 * val2);
                        break;
                    case '/':
                        st.push(val1 / val2);
                        break;
                }
            }
        }
        return st.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Postfix expression: ");
        String exp = sc.nextLine();
        System.out.println("Postfix Evaluation Result: " + evaluatePostfix(exp));
    }
}
