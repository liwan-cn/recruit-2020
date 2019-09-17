package baidu0917;


/**
 * 给定n, m, k
 * 求满足(n-a) * (m-b) <= k 的 min(a+b)
 */


import java.util.*;

public class MinSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        long k = sc.nextLong();
        long t = k / Math.max(n, m);
        System.out.println(Math.min(n, m) - t);
    }
}

/*
12 18 100
7
a = 7, b = 0
 */