package L373_Find_K_Pairs_with_Smallest_Sums;

import java.util.*;

/**
 * Created by he on 17-6-3.
 */
public class Solution {
    public class MyComparator implements Comparator<int[]> {  //实现比较器
        @Override
        public int compare(int[] nums1, int[] nums2) {
            int sum1 = nums1[0] + nums1[1];
            int sum2 = nums2[0] + nums2[1];
            if(sum1 > sum2)
                return 1;
            else
                return -1;
        }
    }
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int []> res = new LinkedList<>();
        Map<int[], Integer> sumPair = new TreeMap<int[], Integer>(new MyComparator());
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){

                int[] tmp = new int[2];
                tmp[0] = nums1[i];
                tmp[1] = nums2[j];
                System.out.println("(" + String.valueOf(tmp[0]) + ", " + String.valueOf(tmp[1]) + ")");
                Integer numtmp = sumPair.get(tmp);
                if(numtmp != null)
                    sumPair.put(tmp, numtmp + 1);
                else sumPair.put(tmp, 1);
            }
        }
        Set<int[]> keySet = sumPair.keySet();
        Iterator<int[]> iterable = keySet.iterator();
        int count = 0;
        System.out.println(sumPair.toString());
        while (iterable.hasNext() && count < k){
            int[] tmpPair = iterable.next();
            Integer pairNum = sumPair.get(tmpPair);
            System.out.println(pairNum);
            while (pairNum > 0) {
                res.add(tmpPair);
                count++;
                pairNum--;
                if(count >= k){
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,1,2};
        int[] nums2 = {1,2,3};
        Solution solution = new Solution();
        System.out.println(solution.kSmallestPairs(nums1, nums2, 100).toString());
    }
}
