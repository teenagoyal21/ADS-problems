
import java.util.*;
import java.util.Stack;
//496, 503

public class nextGreaterElemStack {
    //given an circular array of int we need to find the next greater element of each ele
    //if no such element exists return -1

    //input = {1,2,1};
    //output = {2,-1,2};

    //nums={3,8,4,1,2};
    //op = {8,-1,8,2,3};

    // a monotonic dec stack helps efficiently find the next greater element
    //we use stack to track next greater value

    //optimized way
    //use stack
    //store indices in monotonic dec order
    //process elements twice(2N);
    //use i%n
    public static int[] nextGreaterElement(int[] nums){
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();

        for(int i = 0;i<2*n;i++){
            int num = nums[i%n];
            while(!stack.isEmpty() && nums[stack.peek()] < num){
                result[stack.pop()] = num;
            }
            if(i<n){
                stack.push(i);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(Arrays.toString(nextGreaterElement(nums)));
    }
}
