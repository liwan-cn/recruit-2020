package hulu0905.Test1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long hao = 0, huai = 0;
        int n = sc.nextInt(), m = sc.nextInt();
        int res = lastRemaining(n, m);
        int []a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int []w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if (a[(i + res) % n] == 1) hao += w[i];
            else huai += w[i];
        }
        System.out.println(String.format("%.5f", (double)hao / (hao + huai)));
    }
    public static int lastRemaining(int n, int m) {
        if (m == 0) return -1;
        int res = 0;
        for (int i = 2; i <= n ; i++){
            res = (res + m) % i;
        }
        return res;
    }
}
