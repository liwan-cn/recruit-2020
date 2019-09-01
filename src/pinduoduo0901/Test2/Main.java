package pinduoduo0901.Test2;

/*
n 个色子, 第i个可以等概率的掷出1-xi, 求最大值的期望
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        int max = 1;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(arr[i], max);
        }
        double res = 0;
        double pre = 0;
        for (int t = 1; t <= max; t++) {
            double p = 1.0;
            for (int i = 0; i < n; i++) {
                p *= t >= arr[i] ? 1.0 : t * 1.0 / arr[i];
            }
            double tmpPre = p;
            p = p - pre;
            res += p * t;
            pre = tmpPre;
        }
        System.out.println(String.format("%.2f", res));
    }
}
