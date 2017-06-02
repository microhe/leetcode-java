package L349_Intersection_of_Two_Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by he on 17-6-2.
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        while(true){
            if(i > 0){
                while(i < nums1.length && nums1[i] == nums1[i-1]) i++;
            }
            if(j > 0){
                while(j < nums2.length && nums2[j] == nums2[j-1]) j++;
            }
            if(i < nums1.length && j < nums2.length) {
                if (nums1[i] == nums2[j]) {
                    res.add(nums1[i]);
                    i++;
                    j++;
                } else if (nums1[i] > nums2[j]) {
                    j++;
                } else {
                    i++;
                }
            } else{
                break;
            }
        }
        int[] tmp = new int[res.size()];
        for(i =0; i < tmp.length; i++){
            tmp[i] = res.get(i);
        }
//        System.out.println(res.toString());
        return tmp;
    }

    public static void main(String[] args) {
        int [] a = {1,3,8,9,3};
        int [] b = {1,0};
        Solution solution = new Solution();
        System.out.println(solution.intersection(a ,b));
    }
}
