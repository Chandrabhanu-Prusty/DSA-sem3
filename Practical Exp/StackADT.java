class StackADT{
    int size;
    private int arr[];
    private int top;

    StackADT(int size){
        this.size = size;
        arr = new int[size];
        top = -1;
    }

    void push(int x){
        if(top<size-1){
            top++;
            arr[top]=x;
        }
        else{
            System.out.println("Stack Overflow");
        }
    }

    int pop(){
        if(top==-1){
            System.out.println("Stack Underflow");
        }
        else{
            return arr[top--];
        }
        return -1;
    }

    void peek(){
        System.out.println("Top most element = " + arr[top]);
    }

    void print(){
        for (int i = top; i > -1; i--) {
            System.out.println(arr[i]);
        }
        System.out.println("_______________");
    }

    public static void main(String[] args) {
        StackADT s1 = new StackADT(5);
        s1.push(4);
        s1.push(5);
        s1.push(10);
        s1.push(6);
        s1.push(16);
        s1.push(66);
        s1.print();
        s1.pop();
        s1.print();
        s1.peek();
    }
}
