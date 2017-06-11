package L113_Path_Sum_II;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by he on 17-6-11.
 */
public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x;}
    }
    private int sum;
    private List<List<Integer>> res;
    private boolean hasPathSumHelper(TreeNode node, int tSum, ArrayList<Integer> list){
        if (node == null) return false;
        ArrayList<Integer> tmpList = (ArrayList<Integer>) list.clone();
        tmpList.add(node.val);
        tSum += node.val;
        if(tSum == this.sum && node.left == null && node.right == null){
            res.add(tmpList);
            return true;
        }
        this.hasPathSumHelper(node.left, tSum, tmpList);
        this.hasPathSumHelper(node.right, tSum, tmpList);
        return false;
    }
    public List<List<Integer>> hasPathSum(TreeNode root, int sum) {
        this.sum = sum;
        this.res = new LinkedList<>();
        this.hasPathSumHelper(root, 0, new ArrayList<Integer>());
        return  res;
    }
    public void solve(){
        int[] a = {5,4,8,11,-1,13,4,7,2,-1,-1,5,1};
        Deque<TreeNode> queue = new ArrayDeque<>();
        TreeNode rootNode = new TreeNode(a[0]);
        queue.addLast(rootNode);
        for(int i = 0; i < a.length; i++){
            TreeNode tmpNode = queue.poll();
            if(tmpNode == null) continue;
            if(a[i] == -1)
                tmpNode.left = null;
            else
                tmpNode.left = new TreeNode(a[i]);
            i++;
            if(a[i] == -1)
                tmpNode.right = null;
            else
                tmpNode.right = new TreeNode(a[i]);
        }
        System.out.println(this.hasPathSum(rootNode, 22).toString());
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }
}
