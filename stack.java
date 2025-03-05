
import java.util.Stack;

//stack : LIFO
//push
//pop

public class stack {
    public static void main(String[] args) {
        Stack<Object> stack = new Stack<>();
        stack.push(1);
        stack.push("teena");
        stack.push(1234567898);
        System.out.println(stack);
        
        System.out.println(stack.peek());
        stack.pop();
        stack.pop();
        System.out.println(stack.isEmpty());
    }
}