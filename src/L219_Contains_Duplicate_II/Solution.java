package L219_Contains_Duplicate_II;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by he on 17-5-29.
 */
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> numsMap  = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            Integer index = numsMap.get(nums[i]);
            if(index != null && (i - index) <= k){
                return true;
            }
            numsMap.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3,4,2};
        System.out.println(solution.containsNearbyDuplicate(nums, 3));
    }
}
