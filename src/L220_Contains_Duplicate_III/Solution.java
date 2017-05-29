package L220_Contains_Duplicate_III;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by he on 17-5-29.
 */
public class Solution {
    public boolean containsNearbyAlmostDuplicateHael
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int row = nums.length / k;
        if(nums.length % k != 0)
            row++;
        int[][] numsSplit = new int[row][k];
        int i = 0, j = 0;
        for (int num : nums){
            if(j >= k){
                i++;
                j = 0;
            }
            numsSplit[i][j] = num;
            j++;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3,4,2};
        System.out.println(solution.containsNearbyAlmostDuplicate(nums, 3, 3));
    }
}
