class Stack {
    int[] arr;
    int top, size;

    Stack(int n) {
        arr = new int[n];
        size = n;
        top = -1;
    }

    void push(int x) {
        if (top < size - 1)
            arr[++top] = x;
    }

    int pop() {
        if (top >= 0)
            return arr[top--];
        return -1;
    }

    boolean isEmpty() {
        return top == -1;
    }
}

class PostfixEvaluation {

    static int evaluate(String exp) {
        Stack st = new Stack(exp.length());

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            // skip spaces
            if (c == ' ')
                continue;

            // if operand -> push to stack
            if (Character.isDigit(c)) {
                st.push(c - '0'); // convert char to int
            }
            // if operator -> pop two, perform operation, push result
            else {
                int val2 = st.pop();
                int val1 = st.pop();

                switch (c) {
                    case '+': st.push(val1 + val2); break;
                    case '-': st.push(val1 - val2); break;
                    case '*': st.push(val1 * val2); break;
                    case '/': st.push(val1 / val2); break;
                }
            }
        }

        return st.pop(); // final result
    }

    public static void main(String[] args) {
        String exp = "231*+9-";  // equivalent to 2 + (3*1) - 9
        System.out.println("Postfix Expression: " + exp);
        System.out.println("Evaluated Result: " + evaluate(exp));
    }
}
