package L368_Largest_Divisible_Subset;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by he on 17-6-23.
 */
public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new LinkedList<>();
        if(nums.length == 0)
            return res;
        Arrays.sort(nums);
        int [] numTag = new int[nums.length];
        int [] numLength = new int[nums.length];
        for(int i = 0; i < numTag.length; i++)
            numTag[i] = -1;
        for(int i = 1; i < nums.length; i++){
            for(int j = i - 1; j >= 0; j--){
                if(nums[i] % nums[j] == 0 && (numLength[j] + 1) > numLength[i]){
                    numTag[i] = j;
                    numLength[i] = numLength[j] + 1;
                }
            }
        }
        int maxLengthIndex = 0;
        for(int i = 0; i < numLength.length; i++){
            if(numLength[maxLengthIndex] < numLength[i])
                maxLengthIndex = i;
        }
        int index = maxLengthIndex;
        while(index > -1){
            res.add(nums[index]);
            index = numTag[index];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {4,8,10,240};
        Solution solution = new Solution();
        System.out.println(solution.largestDivisibleSubset(a));
    }
}
