import java.util.Stack;

import javax.swing.tree.TreeNode;

class LC230Solution {
    //DFS Iterative
    public int KthSmallestDFSIterative(TreeNode root, int k) {
        
        Stack<TreeNode> stack = new Stack<>();

        //Traverse to the very left of the tree
        TreeNode curr = root;
        while(curr != null) {
            stack.push(curr);
            curr = curr.left;
        }

        while(k != 0) {
            curr = stack.pop();
            k--;
            if(k == 0) return curr.val;
            
            //if this node have right node than traverse the right node inorder
            TreeNode right = curr.right;
            while(right != null) {
                stack.push(right);
                right = right.left;
            }
        }
        return -1;
    }

    //DFS Recursive
    public static int count;
    public static int number;
    public int KthSmallestDFSRecursive(TreeNode root, int k) {
        count = k;
        helper(root);
        return number;
    }
    private static void helper(TreeNode node) {
        if(node.left != null) helper(node.left);
        count--;
        if(count == 0) {
            number = node.val;
            return;
        }
        if(node.right != null) helper(node.right);
    }
}