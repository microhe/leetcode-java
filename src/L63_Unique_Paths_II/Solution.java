package L63_Unique_Paths_II;

/**
 * Created by he on 17-5-28.
 */
public class Solution {
    private int [][] dp;
    private int dpFun(int i, int j){
        if(dp[i][j] != -1)
            return dp[i][j];
        if(i == 0)
            dp[i][j] = this.dpFun(0,j - 1);
        else if(j == 0)
            dp[i][j] = this.dpFun(i - 1, 0);
        else
            dp[i][j] = this.dpFun(i - 1, j) + this.dpFun(i, j -1);
        return dp[i][j];
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0;
        this.dp = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if(obstacleGrid[i][j] == 1)
                    this.dp[i][j] = 0;
                else this.dp[i][j] = -1;
            }
        }
        dp[0][0] = 1;
        return dpFun(m - 1, n - 1);
    }

    public static void main(String[] args) {
        int [][] a = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        Solution solution = new Solution();
        System.out.println(solution.uniquePathsWithObstacles(a));
    }
}
