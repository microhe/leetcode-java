package L217_Contains_Duplicate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by he on 17-5-29.
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numsSet  = new HashSet<Integer>();
        for(Integer num:nums){
            if(numsSet.contains(num))
                return true;
            numsSet.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,2};
        System.out.println(solution.containsDuplicate(nums));
    }
}
