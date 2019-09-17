package baidu0917;

/**
 * 两步能不能从 1 走到 n
 * 有 t 组数据
 * 每组数据 n 个点, m 个边
 */

import java.util.*;

public class GoCompany {
    static boolean f = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt();
            Set<Integer> []map = new HashSet[n];
            for (int i = 0; i < n; i++) {
                map[i] = new HashSet<>();
            }
            for (int i = 0; i < m; i++) {
                int x = sc.nextInt() - 1, y = sc.nextInt() - 1;
                map[x].add(y);
                map[y].add(x);
            }
            f = false;
            dfs(map, 0, n-1, 2);
            System.out.println(f ? "POSSIBLE" : "IMPOSSIBLE");
        }

    }

    public static void dfs(Set<Integer> []map, int s, int e, int count) {
        if (count == 2) {
            for (Integer next: map[s]) {
                if (next == e) {
                    f = true;
                    return;
                } else {
                    dfs(map, next, e, count-1);
                }
            }
        } else if (count == 1) {
            for (Integer next: map[s]) {
                if (next == e) {
                    f = true;
                    return;
                }
            }
        }
    }
}
