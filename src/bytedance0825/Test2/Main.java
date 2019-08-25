package bytedance0825.Test2;

import java.util.*;

public class Main {
    static final int MOD = 1_000_000_007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        n >>= 1;
        int []res = new int[n+1];
        res[0] = 1; res[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                res[i] = (int)(res[i] + (long)res[j-1] * res[i-j] % MOD) % MOD;
            }
        }
        System.out.println(res[n]);
    }
}
