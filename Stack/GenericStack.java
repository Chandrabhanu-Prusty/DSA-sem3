class GenericStack <T> {
    T[] arr;
    int top;
    int capacity;

    @SuppressWarnings("unchecked")
    GenericStack(int capacity){
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
        top = -1;
    }

    boolean is_full(){
        if(top==capacity-1){
            return true;
        }
        else return false;
    }

    boolean is_empty(){
        if(top==-1){
            return true;
        }
        else return false;
    }

    //push
    void push(T element){
        if (is_full()){
            System.out.println("Stack is Full");
        }
        else {
            top +=1;
            arr[top] = element;
        }
    }

    //pop
    T pop(){
        if (is_empty()){
            System.out.println("Stack is empty");
        }
        else{
            return arr[top--];
        }
        return null;
    }


    //peek
    void peek(){
        System.out.println("The top most element of Stack is: " + arr[top]);
    }


    //print
    void print(){
        for (int i = top; i>-1; i--) {
            System.out.println("Element at position "  +  i + " is " + arr[i]);
        }
    }
}

class StackOp {
    public static void main(String[] args) {
        GenericStack <Integer> s1 = new GenericStack<>(5);
        s1.push(1);
        s1.push(2);
        s1.print();
        s1.pop();
        s1.peek();
        s1.push(3);
        s1.print();
    }
}