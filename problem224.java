import java.util.Stack;

public class problem224 {
    //basic calculator 

    public static int calculate(String s){
        Stack<Integer> stack = new Stack<>();
        int num = 0, result = 0, sign = 1;

        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);

            if(Character.isDigit(c)){
                num = num * 10 + (c-'0');
            }
            else if(c == '+'){
                result += sign*num;
                num = 0;
                sign = 1;
            }
            else if(c == '-'){
                result += sign*num;
                num = 0;
                sign = -1;
            }
            else if(c == '('){
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            }
            else if(c == ')'){
                result += sign*num;
                num = 0;
                result *= stack.pop();  
                result += stack.pop();
            }
        }
        result += sign*num;
        return result;
    }
    public static void main(String[] args) {
        String exp = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(calculate(exp));
    }
}
