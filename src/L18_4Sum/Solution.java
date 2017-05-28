package L18_4Sum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by he on 17-5-28.
 */
public class Solution {
    private List<List<Integer>> result = new LinkedList<>();
    private int[] nums;
    private int target;
    private void forsumHelper(int i, int j){
        if(this.nums[j] * 4 < target)
            return;
        while (i < j) {
            if(i == 0 || (nums[i] != nums[i - 1])) {
                int k = i + 1;
                int l = j - 1;
                while (k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        this.result.add(Arrays.asList(nums[i], nums[k], nums[l], nums[j]));
                        k++;
                        l--;
                        while (nums[k] == nums[k - 1] && k < l) k++;
                        while (nums[l] == nums[l + 1] && l > k) l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
            i++;
        }
        return;
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        Arrays.sort(this.nums);
        for(int j  = nums.length -1; j > 0; j--){
            if(j == nums.length - 1 || nums[j] != nums[j + 1]){
                this.forsumHelper(0, j);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int a[]= {0,0,0,0};
        Solution solution = new Solution();
        System.out.println(solution.fourSum(a, 0).toString());
    }
}
