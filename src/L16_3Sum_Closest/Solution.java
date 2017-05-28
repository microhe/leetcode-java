package L16_3Sum_Closest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by he on 17-5-28.
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length - 2; i++){
            if(i == 0 || (nums[i] != nums[i-1])){
                int j = i + 1;
                int k = nums.length - 1;
                while (j < k){
                    int sum = nums[j] + nums[k] + nums[i];
                    if(Math.abs(sum - target) < Math.abs(res - target)){
                        res = sum;
                    }
                    if(sum > target){
                        k--;
                    }else if(sum < target){
                        j++;
                    }else{
                        return sum;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int a[]= {1,1,1,0};
        Solution solution = new Solution();
        System.out.println(solution.threeSumClosest(a, 100));
    }
}
