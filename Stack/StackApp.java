class StackInt {
    private static char[] arr;
    private static int top;
    private static int capacity;

    public StackInt(int capacity) {
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

    char peek() {
        if (!isEmpty()) {
            return arr[top];
        }
        return '\0';
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

class StackApp {

    boolean match_brackets(char stack_popped, char expression) {
        return (stack_popped == '(' && expression == ')') ||
                (stack_popped == '{' && expression == '}') ||
                (stack_popped == '[' && expression == ']');
    }

    boolean Parenthesis_Checker(String expression) {
        StackInt para_check_stack = new StackInt(expression.length());

        for (int i = 0; i < expression.length(); i++) {
            char element = expression.charAt(i);

            if (element == '{' || element == '[' || element == '(') {
                para_check_stack.push(element);
            } else if (element == '}' || element == ']' || element == ')') {
                if (para_check_stack.isEmpty())
                    return false;

                char popped = expression.charAt(i);

                if (match_brackets(element, popped))
                    return false;
            }
        }
        return para_check_stack.isEmpty();
    }

    int Precedence(char operator) {
        if (operator == '^') {
            return 3;
        }
        if (operator == '*' || operator == '/') {
            return 2;
        }
        if (operator == '+' || operator == '-') {
            return 1;
        }
        return 0;
    }

    String Infix_to_Postfix(String expression) {
        StackInt postfix_expression = new StackInt(expression.length());
        StringBuilder postfix = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            char element = expression.charAt(i);
            if (Character.isLetterOrDigit(element)) {
                postfix.append(element);
            } else if (element == '(' || element == '[' || element == '{') {
                postfix_expression.push(element);
            } else if (element == ')' || element == ']' || element == '}') {
                while (!postfix_expression.isEmpty() && postfix_expression.peek() != '(') {
                    postfix.append(postfix_expression.pop());
                }
                if (!postfix_expression.isEmpty()) {
                    postfix_expression.pop();
                }
            } else if (element == '+' || element == '-' || element == '*' || element == '/' || element == '^') {
                while (!postfix_expression.isEmpty() && Precedence(postfix_expression.peek()) >= Precedence(element)) {
                    postfix.append(postfix_expression.pop());
                }
                postfix_expression.push(element);
            }
            while (!postfix_expression.isEmpty()) {
                postfix.append(postfix_expression.pop());
            }
           
        }
         return postfix.toString();
    }

    String ConvertCharExpToNumExp(String PostfixExpression) {
        
        return null;
    }

    public static void main(String[] args) {
        StackApp app = new StackApp();

        String expression = "(A+B)*(C+D)";
        System.out.println("Infix Expression: " + expression);

        // Check if the parentheses are balanced
        boolean isBalanced = app.Parenthesis_Checker(expression);
        System.out.println("Is Parentheses Balanced: " + isBalanced);

        // Convert Infix to Postfix
        String postfix = app.Infix_to_Postfix(expression);
        System.out.println("Postfix Expression: " + postfix);
    }
}
