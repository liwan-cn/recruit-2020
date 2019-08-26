package xiaomi0826.Test3;

/**
 * 附近零售店
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            TreeSet<Integer> s = new TreeSet<>();
            int n = sc.nextInt(), m = sc.nextInt();
            for (int i = 0; i < n; i++) {
                s.add(sc.nextInt());
            }
            int res = 0;
            for (int i = 0; i < m; i++) {
                int now = sc.nextInt();
                Integer r = s.ceiling(now), l = s.floor(now);
                int min = Integer.MAX_VALUE;
                if (r != null) {
                    min = Math.min(min, r - now);
                }
                if (l != null) {
                    min = Math.min(min, now - l);
                }
                res += min;
            }
            System.out.println(res);
        }
    }
}
