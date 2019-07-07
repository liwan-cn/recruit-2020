package bytedance0707.Test3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int res = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int []a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        boolean []flag = new boolean[n];
        res = 0;
        int first = a[0];
        dfs(a, flag, first, 1, 0, m);
        System.out.println(res);
    }
    private static void dfs(int []a, boolean []flag, int first, int cnt, int now, int m) {
        if (cnt == a.length) {
            if (Math.abs(a[now] - first) <= m) res++;
            return;
        }
        flag[now] = true;
        for (int i = 0; i < a.length; i++){
            if (!flag[i] && Math.abs(a[now] - a[i]) <= m) {
                dfs(a, flag, first, cnt+1, i, m);
            }
            if (a[i] - a[now] > m) break;
        }
        flag[now] = false;
    }
}
