public class problem63 {
    //given an m*n integer array grid
    //a robot starts from top left corner and aims to reach bottom right corner
    //the robot can move down or right at any pt
    
    //obstacles can be represented by 1 and free spaces by 0
    //we have to return number of nique paths the robot caan take to 
    //reach the bottom right corner.
    //problem 37 leetcode

    public static int uPWO(int[][] oG){
        int m = oG.length;
        int n = oG[0].length;

        if(oG[0][0] == 1 || oG[m-1][n-1] == 1){
            return 0;
        }

        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(oG[i][j] == 1){
                    dp[i][j] = 0;
                }
                else{
                    if(i>0) dp[i][j] += dp[i-1][j];
                    if(j>0) dp[i][j] += dp[i][j-1];
                }
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] oG = {
            {0,0,0},
            {0,1,0},
            {0,0,0}
        };

        System.out.println(uPWO(oG));
    }
}
