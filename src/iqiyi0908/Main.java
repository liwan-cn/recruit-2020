package iqiyi0908;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        double [][]dp = new double[n+1][m+1];
        dp[0][0] = 0.0;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1.0;
            if (m >= 1)  dp[i][1] = (double)i / (i + 1);
            if (m >= 2)  dp[i][2] = ((double)2 / (i + 1) + i) / (i+2);
            //((double)i / (i + 2)) + ((double)2 / (i + 2)) * ((double)1 / (i + 1));
        }
        for (int j = 1; j <= m; j++) {
            dp[0][j] = 0.0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 3; j <= m; j++) {
                dp[i][j] = ((dp[i][j-3] * (j-2)  + dp[i-1][j-2] * i) * j * (j-1) / ((i + j - 1) * (i + j - 2)) + i) / (i+j);
            }
        }
        BigDecimal b   =  new  BigDecimal(dp[n][m]);
        System.out.println(b.setScale(5, RoundingMode.HALF_UP));
        //System.out.println(String.format("%.5f", dp[n][m]));
    }
}
