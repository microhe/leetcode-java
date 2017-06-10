package L112_Path_Sum;

/**
 * Created by he on 17-6-10.
 */

//import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x;}
    }
    private int sum;
    private boolean hasPathSumHelper(TreeNode node, int tSum){
        if (node == null) return false;
        tSum += node.val;
        if(tSum == this.sum && node.left == null && node.right == null)
            return  true;
        if (this.hasPathSumHelper(node.left, tSum))
            return true;
        if(this.hasPathSumHelper(node.right, tSum))
            return true;
        return false;
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        this.sum = sum;
        return this.hasPathSumHelper(root, 0);
    }
}
