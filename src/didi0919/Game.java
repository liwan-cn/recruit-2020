package didi0919;


import java.util.*;

public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int []arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int []dp = new int[n];
        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[i-1] + arr[i], arr[i]);
        }
        //System.out.println(Arrays.toString(dp));
        int win = 0;
        for (int i = 0; i < m; i++) {
            win += arr[i];
        }
        int min = win;
        for (int i = m; i < n; i++) {
            win = win + arr[i] - arr[i-m];

            min = Math.min(min, Math.min(win, win + dp[i-m]));
            //System.out.println(win + ";" + min);
        }
        System.out.println(min);
    }
}
