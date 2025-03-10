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
public class leetcode104 {
    // find maximum depth(height) of a binary tree
    public static int maxDepth(Node root){
        if(root == null){
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right  = new Node(7);
        System.out.println(maxDepth(root));
    }
}
