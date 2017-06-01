package L220_Contains_Duplicate_III;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by he on 17-5-29.
 */
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(2 * t < k && t < k) {
            Map<Integer, Integer> numsMap = new HashMap<Integer, Integer>();
            for (int i = 0; i < nums.length; i++) {
                for (int value = nums[i] - t; value <= nums[i] + t; value++) {
                    Integer index = numsMap.get(value);
                    if (index != null && Math.abs(i - index) <= k) {
                        return true;
                    }
                }
                numsMap.put(nums[i], i);
            }
        } else {
            for(int i = 0; i < nums.length; i++){
                for(int j = i + 1; j <= i + k && j < nums.length; j++){
                    if(Math.abs((long) nums[i] - (long) nums[j]) <= t)
                        return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {7,2,8};
        System.out.println(solution.containsNearbyAlmostDuplicate(nums, 2, 1));
    }
}
