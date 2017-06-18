package L437_Path_Sum_III;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by he on 17-6-18.
 */
public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int sum;
    private int resCount = 0;

    private void PathSumHelper(TreeNode node, int currentSum, Map preSum) {
        if (node == null) return;
        currentSum += node.val;
        if(preSum.containsKey(currentSum - this.sum))
            this.resCount += (int) preSum.get(currentSum - this.sum);
        if(preSum.containsKey(currentSum)) {
            preSum.put(currentSum, (int)preSum.get(currentSum) + 1);
        } else {
            preSum.put(currentSum, 1);
        }
        this.PathSumHelper(node.left, currentSum, preSum);
        this.PathSumHelper(node.right, currentSum, preSum);
        preSum.put(currentSum, (int)preSum.get(currentSum) - 1);
    }

    public int pathSum(TreeNode root, int sum) {
        this.sum = sum;
        LinkedList<Integer> currentList = new LinkedList<>();
        Map preSum = new HashMap<Integer, Integer>();
        preSum.put(0, 1);
        this.PathSumHelper(root, 0, preSum);
        return resCount;
    }
}
