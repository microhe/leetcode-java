package L15_3Sum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by he on 17-5-28.
 */
public class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for(int i = 0; i < nums.length - 2; i++){
            if(i == 0 || (nums[i] <= 0 && nums[i] != nums[i-1])){
                int j = i + 1;
                int k = nums.length - 1;
                while (j < k){
                    int sum = nums[j] + nums[k] + nums[i];
                    if(sum == 0){
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        k--;
                        j++;
                        while (nums[k] == nums[k + 1] && k > j) k--;
                        while (nums[j] == nums[j - 1] && j < k) j++;
                    }else if(sum > 0){
                        k--;
                    }else{
                        j++;
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int a[]= {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        Solution1 solution = new Solution1();
        System.out.println(solution.threeSum(a).toString());
    }
}
