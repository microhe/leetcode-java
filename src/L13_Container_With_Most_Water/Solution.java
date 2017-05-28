package L13_Container_With_Most_Water;

/**
 * Created by he on 17-2-6.
 */

public class Solution {

    public int maxArea(int[] height) {
        int i=0,j=height.length-1;
        int maxarea=0;
        while(i<j){
            maxarea=Math.max(maxarea,Math.min(height[i],height[j])*(j-i));
            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }
        }
        return maxarea;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int [] array = {1,2,4,3};
        System.out.println(solution.maxArea(array));
    }
}
