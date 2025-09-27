import java.util.ArrayList;

class Bracket {
    static void check(char[] arr) {
        int i = 0;
        ArrayList<Character> stack = new ArrayList<>();

        while (i < arr.length) {
            char X = arr[i];

            // Push opening brackets
            if (X == '(' || X == '[' || X == '{') {
                stack.add(X);
            }
            // Handle closing brackets
            else if (X == ')' || X == ']' || X == '}') {
                if (stack.isEmpty()) {
                    System.out.println("False");
                    return;
                }
                char top = stack.get(stack.size() - 1);
                if (match(top, X)) {
                    stack.remove(stack.size() - 1); // Pop from stack
                } else {
                    System.out.println("False");
                    return;
                }
            }
            // Handle invalid characters
            else {
                System.out.println("Use appropriate bracket");
                return;
            }

            i++;
        }

        // Final check: stack should be empty
        if (stack.isEmpty()) {
            System.out.println("Correct use of brackets");
        } else {
            System.out.println("False");
        }
    }

    static boolean match(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}');
    }
}

class Main {
    public static void main(String[] args) {
        char[] arr = {'(','(','{','(','[',']','(',')',')','}'};
        Bracket.check(arr);
    }
}
