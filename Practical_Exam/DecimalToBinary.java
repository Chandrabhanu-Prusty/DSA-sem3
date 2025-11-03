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

class DecimalToBinary {

    static void convert(int num) {
        Stack st = new Stack(100);

        // Push remainders into stack
        while (num > 0) {
            st.push(num % 2);
            num = num / 2;
        }

        // Pop and print binary digits
        System.out.print("Binary: ");
        while (!st.isEmpty()) {
            System.out.print(st.pop());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int num = 25;
        System.out.println("Decimal: " + num);
        convert(num);
    }
}
