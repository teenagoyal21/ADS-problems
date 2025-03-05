class Node{ 
    int data;
    Node next;
    Node(int val){
        this.data = val;
        this.next = null;
    }

}
class Stack {
    Node head;
    public Stack() {
        this.head = null;
    }
    boolean isEmpty(){
        return head == null;
    }
    void push(int val){
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }
    int pop(){
        if(isEmpty()){
            System.out.println("underflow");
            return -1;
        }
        else{
            int value = head.data;
            Node temp = head;
            head = head.next;
            temp = null;
            return value;
        }
    }
    int peek(){
        return head.data;
    }
}

public class stackLinkedList {
    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(10);
        st.push(20);
        st.push(40);
        System.out.println(st.pop());
        System.out.println(st.peek());

    }
}
