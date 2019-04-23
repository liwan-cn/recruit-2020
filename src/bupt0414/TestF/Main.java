package bupt0414.TestF;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long [][]dp = new long [64][9];
        for (int i = 0; i < 64; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i < 64; i++){
            for (int j = 1; j < 9;j++){
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
        while (sc.hasNext()){
            int n = sc.nextInt();
            n--;
            long res = 0;
            int cnt = 8;
            for (int i = 63; i >= 0; i--){
                if (dp[i][cnt]  > n){
                    continue;
                } else {
                    res ^= (1L << i);
                    n -= dp[i][cnt];
                    cnt --;

                }
            }
            System.out.println(res);
        }

    }
}
