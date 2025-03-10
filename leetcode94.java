import java.util.*;
import java.util.Stack;

class Node{
    int val;
    Node left;
    Node right;
    Node(int data){
        val = data;
        this.left = null;
        this.right = null;
    }
}

public class leetcode94 {
    public static List<Integer> inorderTrav(Node root){
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node curr = root;

        while(curr != null || !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }
    public static void main(String[] args) {
        //given the root of bt, return its inorder traversal(left, root, right)

        //approach: recursive(DFS)
        //traverse to left subtree, then to root , and then to right subtree
        //TC: O(n), SC: O(n)
        Node root = new Node(1);
        root.right = new Node(2);
        root.right.left = new Node(3);
        System.out.println(inorderTrav(root)); 
    }
}
