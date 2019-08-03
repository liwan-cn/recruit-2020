package yuanfudao0803.Test3;

import java.util.*;

public class Main {
    public static final int MOD = 100_000_007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), k = sc.nextInt();
        long notAtme = 0, atMe = 1;
        for (int i = 0; i < m; i++) {
            long tmp = notAtme;
            notAtme= ((notAtme % MOD) * (k-2) % MOD + (atMe % MOD * (k-1)) % MOD) % MOD;
            atMe = tmp;
        }
        System.out.println(atMe);
    }
}
