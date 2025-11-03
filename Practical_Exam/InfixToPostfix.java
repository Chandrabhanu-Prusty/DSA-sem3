class Stack {
    char[] arr;
    int top, size;

    Stack(int n) {
        arr = new char[n];
        size = n;
        top = -1;
    }

    void push(char c) {
        if (top < size - 1)
            arr[++top] = c;
    }

    char pop() {
        if (top >= 0)
            return arr[top--];
        return '\0';
    }

    char peek() {
        if (top >= 0)
            return arr[top];
        return '\0';
    }

    boolean isEmpty() {
        return top == -1;
    }
}

class InfixToPostfix {

    static int precedence(char c) {
        if (c == '^') return 3;
        if (c == '*' || c == '/') return 2;
        if (c == '+' || c == '-') return 1;
        return -1;
    }

    static String convert(String infix) {
        Stack st = new Stack(infix.length());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            // if operand -> add to result
            if (Character.isLetterOrDigit(c))
                result.append(c);

            // if '(' -> push to stack
            else if (c == '(')
                st.push(c);

            // if ')' -> pop until '('
            else if (c == ')') {
                while (!st.isEmpty() && st.peek() != '(')
                    result.append(st.pop());
                st.pop(); // remove '('
            }

            // if operator
            else {
                while (!st.isEmpty() && precedence(c) <= precedence(st.peek()))
                    result.append(st.pop());
                st.push(c);
            }
        }

        // pop all remaining operators
        while (!st.isEmpty())
            result.append(st.pop());

        return result.toString();
    }

    public static void main(String[] args) {
        String infix = "(A+B)*C-(D-E)*(F+G)";
        System.out.println("Infix: " + infix);
        System.out.println("Postfix: " + convert(infix));
    }
}
