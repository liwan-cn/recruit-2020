package alibaba0412.Test2;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt(), k = sc.nextInt();
        int [][]dpm = nPutK(m ,k), dpn = nPutK(n, k);
        int res = 0;
        for (int notEmpty = 2; notEmpty <= k; notEmpty++){
            for (int x = 1; x < notEmpty; x ++){
                int y = notEmpty - x;
                if (x <= m && y <= n){
                    res += dpm[m-x][x] * dpn[n-y][y];
                    System.out.println("***************");
                    System.out.println(m + " ==> " + x + " : " +dpm[m-x][x]);
                    System.out.println(n + " ==> " + y + " : " +dpn[n-y][y]);
                }
            }
        }
        System.out.println(res);
    }
    private static int[][] nPutK(int n, int k){
        int [][]dp = new int[n+1][k+1];
        for (int i = 0; i <= n; i++){
            dp[i][0] = 1; dp[i][1] = 1;
        }
        for (int j = 0; j <= k; j++){
            dp[0][j] = 1; dp[1][j] = 1;
        }
        for (int i = 2; i <= n ;i++){
            for (int j = 2; j <= k; j++){
                if (i < j)
                    dp[i][j] = dp[i][i];
                else
                    dp[i][j] = dp[i][j-1] + dp[i-j][j];
            }
        }
        return dp;
    }
}
