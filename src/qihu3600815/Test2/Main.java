package qihu3600815.Test2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        Map<Integer, Integer> a = new HashMap<>();
        Map<Integer, Integer> b = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int key = sc.nextInt() % m;
            a.put(key, a.getOrDefault(key, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            int key = sc.nextInt() % m;
            b.put(key, a.getOrDefault(key, 0)+1);
        }
        int []res = new int[m];
        for (int i = m - 1; i >= 0; i--){
            for (int ak : a.keySet()) {
                int bk = (i - ak + m) % m;
                int av = a.getOrDefault(ak, 0), bv = b.getOrDefault(bk, 0);
                int cnt = Math.min(av, bv);
                if (cnt == 0) continue;
                if (cnt == av) {
                    a.remove(ak);
                } else {
                    a.put(ak, av - cnt);
                }
                if (cnt == bv) {
                    b.remove(bk);
                } else {
                    b.put(bk, bv - cnt);
                }
                res[i] += cnt;
            }
        }
        int cnt = 0;
        for (int i = m-1; i >= 0; i--){
            if (res[i] > 0) {
                while (res[i]-- > 0) {
                    if (cnt == n-1) {
                        System.out.println(i);
                        cnt ++;
                    } else {
                        System.out.print(i + " ");
                        cnt ++;
                    }
                }

            }
        }
    }
}
/*
5 5
4 4 1 1 1
4 3 0 1 2
 */