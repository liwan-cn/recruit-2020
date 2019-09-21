package tencent0920;

import java.util.*;

public class Paint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(getMin(a, 0, n-1, 0));
    }
    public static int getMin(int []a, int s, int e, int base) {
        if (s > e) return 0;
        //if (s == e) return Math.min(1, a[s]-base);
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = s; i <= e; i++) {
            if (a[i] < min) {
                min = a[i];
                index = i;
            }
        }
        return Math.min(e-s+1, min-base + getMin(a, s, index-1, min) + getMin(a, index+1, e, min));
    }
}
