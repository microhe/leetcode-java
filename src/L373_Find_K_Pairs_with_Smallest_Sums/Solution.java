package L373_Find_K_Pairs_with_Smallest_Sums;

import java.util.*;

/**
 * Created by he on 17-6-3.
 */
public class Solution {
public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    List<int []> res = new LinkedList<>();
    if(nums1.length == 0 || nums2.length == 0)
        return res;
    boolean isSwap = false;
    if (nums1.length > nums2.length){
        int[] tmp = nums2;
        nums2 = nums1;
        nums1 = tmp;
        isSwap = true;
    }
    int[] nums2Indexs = new int[nums1.length];
    int[] sumValue = new int[nums1.length];
    for(int i = 0; i < nums1.length; i++){
        nums2Indexs[i] = 0;
        sumValue[i] = nums1[i] + nums2[0];
    }
    int MAXSUM = nums1[nums1.length - 1] + nums2[nums2.length - 1] + 1;
    int num1Index = 0;
    while(res.size() < k){
        int minValIndex = 0;
        for(int i = 0; i < nums1.length; i++){
            if(sumValue[i] < sumValue[minValIndex]){
                minValIndex = i;
            }
        }
        num1Index = minValIndex;
        if(sumValue[num1Index] == MAXSUM) break;
        if (isSwap) {
            int[] tmp = {nums2[nums2Indexs[num1Index]], nums1[num1Index]};
            res.add(tmp);
        } else{
            int[] tmp = {nums1[num1Index], nums2[nums2Indexs[num1Index]]};
            res.add(tmp);
        }
        nums2Indexs[num1Index] ++;
        if(nums2Indexs[num1Index] < nums2.length)
            sumValue[num1Index] = nums1[num1Index] + nums2[nums2Indexs[num1Index]];
        else sumValue[num1Index] = MAXSUM;
    }
    return res;
}
    public static void main(String[] args) {
        int[] nums1 = {1,1,2};
        int[] nums2 = {1,2,3};
        Solution solution = new Solution();
        System.out.println(solution.kSmallestPairs(nums1, nums2, 2).toString());
    }
}
