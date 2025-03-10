import java.util.ArrayList;
import java.util.List;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int data){
        val = data;
        this.left = null;
        this.right = null;
    }
}

public class leetcode257 {
    public static void func(TreeNode root, String curr, List<String> list){
        if(root == null){
            return;
        }
        curr = curr + Integer.toString(root.val);
        if(root.left == null && root.right == null){
            list.add(curr);
            return;
        }
        func(root.left, curr+"->", list);
        func(root.right, curr+"->", list);
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        String curr = "";
        if(root == null){
            return list;
        }
        func(root, curr, list);
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        System.out.println(binaryTreePaths(root));
    }
}
