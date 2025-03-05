import java.util.*;

class Node{ 
    int val;
    Node left;
    Node right;
    public Node(int data){
        val = data;
        this.left = null;
        this.right = null;
    }
}

public class leetcode112 {
    public static Node buildTree(int[] arr){
        if(arr.length == 0){
            return null;
        }
        Node root = new Node(arr[0]);
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int i = 1;
        while(i < arr.length){
            Node front = q.poll();

            if(i < arr.length && arr[i] != -1){
                front.left = new Node(arr[i]);
                q.add(front.left);
            }
            i++;

            if(i < arr.length && arr[i] != -1){
                front.right = new Node(arr[i]);
                q.add(front.right);
            }
            i++;
        }

        return root;
    }

    public static boolean hasPathSum(Node node, int targetSum) {
        if(node == null){
            return false;
        }

        if(node.left == null && node.right == null && targetSum - node.val == 0){
            return true;
        }

        targetSum -= node.val;

        return hasPathSum(node.left, targetSum) || hasPathSum(node.right, targetSum);
    }

    public static void main(String[] args) {
        int arr[] = {5,4,8,11,-1,13,4,7,2,-1,-1,-1,1};
        int target = 22;

        Node root = buildTree(arr);

        System.out.println(hasPathSum(root, target));
    }
}
