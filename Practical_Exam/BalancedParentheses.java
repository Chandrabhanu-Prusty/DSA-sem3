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
        return '\0'; // return null char if empty
    }

    boolean isEmpty() {
        return top == -1;
    }
}

class BalancedParentheses {

    static boolean isBalanced(String exp) {
        Stack st = new Stack(exp.length());

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (c == '(' || c == '{' || c == '[')
                st.push(c);
            else if (c == ')' || c == '}' || c == ']') {
                if (st.isEmpty())
                    return false;

                char top = st.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '['))
                    return false;
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        String exp1 = "{[()]}";
        String exp2 = "(([)]";
        String exp3 = "({[]})";

        System.out.println(exp1 + " → " + (isBalanced(exp1) ? "Balanced" : "Not Balanced"));
        System.out.println(exp2 + " → " + (isBalanced(exp2) ? "Balanced" : "Not Balanced"));
        System.out.println(exp3 + " → " + (isBalanced(exp3) ? "Balanced" : "Not Balanced"));
    }
}
