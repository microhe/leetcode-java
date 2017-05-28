package L15_3Sum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


/**
 * Created by he on 17-5-27.
 */
public class Solution {
    private List<List<Integer>> result = new ArrayList<List<Integer>>();
    private HashMap<ArrayList, Integer> repet = new HashMap<ArrayList, Integer>();
    private void addList(int a, int b, int c){
        ArrayList tmpList = new ArrayList();
        if(c < a){
            tmpList.add(c);
            tmpList.add(a);
            tmpList.add(b);
        }else if(c > b){
            tmpList.add(a);
            tmpList.add(b);
            tmpList.add(c);
        }else{
            tmpList.add(a);
            tmpList.add(c);
            tmpList.add(b);
        }
        if(repet.get(tmpList) == null){
            this.result.add(tmpList);
            this.repet.put(tmpList,1);
        }

    }
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<Integer> negative = new HashSet<Integer>();
        HashSet<Integer> positive = new HashSet<Integer>();
        HashMap<Integer, Integer> numsHash = new HashMap<Integer, Integer>();
        boolean zero = false;
        int zeroNum = 0;
        for(int num:nums){
            if(num < 0){
                negative.add(-num);
            }else if(num > 0){
                positive.add(num);
            }else{
                zero = true;
                zeroNum ++;
            }
            Integer tmp = numsHash.get(num);
            if(tmp == null){
                numsHash.put(num, 1);
            }else{
                numsHash.put(num, tmp + 1);
            }
        }
        if(zeroNum >= 3){
            this.addList(0, 0, 0);
        }
        int diffVal;
        for(Integer negativeNum:negative) {
            for (Integer positiveNum:positive) {
                diffVal = negativeNum - positiveNum;
                if(diffVal > 0){
                    Integer tmp = numsHash.get(diffVal);
                    if(tmp != null){
                        if(diffVal != positiveNum || tmp > 1){
                            this.addList(-negativeNum, positiveNum, diffVal);
                        }
                    }
                }else if(diffVal < 0){
                    Integer tmp = numsHash.get(diffVal);
                    if(tmp != null){
                        if(-diffVal != negativeNum || tmp > 1){
                            this.addList(-negativeNum, positiveNum, diffVal);
                        }
                    }
                }else {
                    if(zero){
                        this.addList(-negativeNum, positiveNum, 0);
                    }
                }
            }
        }
        return this.result;
    }

    public static void main(String[] args) {
        int a[]= {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        Solution solution = new Solution();
        System.out.println(solution.threeSum(a).toString());
    }
}
