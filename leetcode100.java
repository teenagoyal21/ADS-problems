import java.util.*;

class Node {
    int val;
    Node left;
    Node right;
    public Node(int data){
        val = data;
        this.left = null;
        this.right = null;
    }
}

public class leetcode100 {
    public static boolean isSameTree(Node p, Node q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null || p.val != q.val){
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

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

            if (i < arr.length && arr[i] != -1) {
                front.left = new Node(arr[i]);
                q.add(front.left);
            }
            i++;

            if (i < arr.length && arr[i] != -1) {
                front.right = new Node(arr[i]);
                q.add(front.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2};
        int[] arr2 = {1,-1,2};

        Node root1 = buildTree(arr1);
        Node root2 = buildTree(arr2);

        System.out.println(isSameTree(root1, root2));
    }
}
