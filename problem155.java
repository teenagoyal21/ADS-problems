import java.util.Stack;

public class problem155 {
    private Stack<Integer> stack;
    private Stack<Integer> minstack;

    public problem155(){
        stack = new Stack<>();
        minstack = new Stack<>();
    }

    public void push(int val){
        stack.push(val);
        if(minstack.isEmpty() || val <= minstack.peek()){
            minstack.push(val);
        }
        else{
            minstack.push(minstack.peek());
        }
    }

    public void pop(){
        if(!stack.isEmpty()){
            minstack.pop();
            stack.pop();
        }
    }

    public int top(){
        return stack.peek();
    }

    public int getMin(){
        return minstack.peek();
    }

    public static void main(String[] args) {
        problem155 p = new problem155();
        p.push(-2);
        p.push(0);
        p.push(-3);
        System.out.println(p.getMin());
        p.pop();
        System.out.println(p.top());
        System.out.println(p.getMin());
    }
}
