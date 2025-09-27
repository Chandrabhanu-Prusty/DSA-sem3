class Stack {
    int[] arr;
    int top;
    int capacity;

    Stack(int capacity){
        this.capacity = capacity;
        arr = new int[capacity];
        top = -1;
    }

    //push
    void push(int element){
        if(top<capacity-1){
            top +=1;
            arr[top] = element;
        }
        else{
            System.out.println("Stack is full");
        }
    }

    //pop
    int pop(){
        if(top==-1){
            System.out.println("Stack is empty");
        }
        else{
            int val = arr[top];
            top = top-1;
            return val;
//            return arr[top--];
        }
        return 0;
    }

    //peek
    void peek(){
        System.out.println("The top most element: "+ arr[top]);
    }

    //print
    void print(){
        for (int i = top; i>-1; i--) {
            System.out.println("Element at position "  +  i + " is " + arr[i]);
        }
    }
}

class op {
    public static void main(String[] args) {
        Stack s1 = new Stack(5);
        s1.push(23);
        s1.push(45);
        s1.push(65);
        s1.print();
        int val = s1.pop();
        System.out.println("Popped element: "+val);
        s1.peek();
        s1.push(89);
        s1.print();
    }
}