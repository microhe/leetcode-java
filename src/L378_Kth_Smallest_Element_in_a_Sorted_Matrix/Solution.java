package L378_Kth_Smallest_Element_in_a_Sorted_Matrix;

/**
 * Created by he on 17-7-16.
 */
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int res = matrix[0][0];
        int[] colIndex = new int[n];
        while (k > 0){
            int minValRowIndex = 0;
            for (int i = 1; i < n; i++){
                if (colIndex[i] < n) {
                    if (colIndex[minValRowIndex] >= n || matrix[i][colIndex[i]] < matrix[minValRowIndex][colIndex[minValRowIndex]]){
                        minValRowIndex = i;
                    }
                }
            }
            if(colIndex[minValRowIndex] >= n)
                break;
            res = matrix[minValRowIndex][colIndex[minValRowIndex]];
            colIndex[minValRowIndex]++;
            k--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1,  5,  9},
                {10, 11, 13},
                {12, 13, 15}
        };
        Solution solution = new Solution();
        System.out.println(solution.kthSmallest(matrix, 8));
    }
}
