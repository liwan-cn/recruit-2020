package vivo0911;


public class Clear {
    public static void main(String[] args) {
        System.out.println(clear(new int[]{1,4,2,2,3,3,2,4,1}));
    }
    private static int clear(int []arr) {
        int [][]dp = new int[arr.length][arr.length];
        for (int i = arr.length-1; i >= 0; i--){
            dp[i][i] = 1;
            for (int j = i + 1; j < arr.length; j++){
                dp[i][j] = Integer.MIN_VALUE;
                for (int k = i; k < j; k++){
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j]);
                }
                if (arr[i] == arr[j]){
                    if (i + 1 == j)
                        dp[i][j] = 1;
                    else
                        dp[i][j] = Math.min(dp[i][j], dp[i+1][j-1]);
                }
                //System.out.println(i + ";" + j + "; "+ dp[i][j]);
            }
        }
        return dp[0][arr.length-1];
    }
}
