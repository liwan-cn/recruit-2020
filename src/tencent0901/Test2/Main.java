package tencent0901.Test2;

import java.util.*;

public class Main {

    public static long comb(int n, int m){
        if ( n== 1 && m > 0) return 1;
        int u = 1, d = 1;
        for (int i = 0; i < m; i++) {
            u *= (n-i);
            d *= (i + 1);
        }
        return u/d;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(), k = sc.nextInt();
        while (t -- > 0) {
            int s = sc.nextInt(), e = sc.nextInt();
            int res = 0;
            for (int j = s; j <= e; j ++) {
                if (j < k) res += 1;
                else if(j == k) res += 2;
                else {
                    int bb = j / k;
                    for (int ll = 0; ll <= bb; ll++) {
                        int rr = j - ll * k;
                        res += comb(rr + 1, ll);
                    }
                }
            }
            System.out.println(res);
        }

    }
}
