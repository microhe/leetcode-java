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
    private void PathSumHelper(TreeNode node, int tSum, LinkedList<Integer> currentList){
        if (node == null) return;
        currentList.addLast(node.val);
        int tmpSum = tSum + node.val;
        if(tmpSum == this.sum && node.left == null && node.right == null){
            res.add(new LinkedList<>(currentList));
            currentList.removeLast();
            return;
        } else {
            this.PathSumHelper(node.left, tmpSum, currentList);
            this.PathSumHelper(node.right, tmpSum, currentList);
        }
        currentList.removeLast();
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.sum = sum;
        this.res = new LinkedList<List<Integer>>();
        LinkedList<Integer> currentList = new LinkedList<>();
        this.PathSumHelper(root, 0, currentList);
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
        System.out.println(this.pathSum(rootNode, 22).toString());
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }
}
