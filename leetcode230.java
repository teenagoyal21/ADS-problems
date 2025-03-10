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

public class leetcode230 {
    //Kth smallest element in a BST
    //approach - use inorder (lrootR) to get elements in sorted order
    //stop when kth element is found

    public static int kthSmallest(Node root, int k){

        Stack<Node> stack = new Stack<>();
        while(true){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(--k == 0) return root.val;
            root = root.right;
        }
        
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(1);
        root.right = new Node(4);
        System.out.println(kthSmallest(root, 2));

    }
}
