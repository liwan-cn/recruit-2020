package netease0921;

import java.util.*;

public class Jump {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), k = sc.nextInt();
            int []h = new int[n];
            for (int i = 0; i < n; i++) {
                h[i] = sc.nextInt();
            }
            boolean []front = new boolean[n];
            front[0] = true;
            for (int i = 0; i < n; i++) {
                if (front[i]){
                    for (int j = 1; j <= k; j++) {
                        if (i + j >= n) break;
                        front[i+j] |= (h[i+j] <= h[i]);
                    }
                }
            }

            boolean []back = new boolean[n];
            back[n-1] = true;
            for (int i = n-1; i >= 0; i--) {
                if (back[i]){
                    for (int j = 1; j <= k; j++) {
                        if (i + j < 0) break;
                        front[i-j] |= (h[i-j] >= h[i]);
                    }
                }
            }

            int f = 0, b = n-1;
            for (int i = 0; i < n; i++) {
                if (front[i]) f = i;
            }

            for (int i = n-1; i >= 0; i--) {
                if (back[i]) b = i;
            }

            System.out.println(b - f <= k ? "YES" : "NO");
        }
    }
}
/*
100
5 3
6 2 4 3 8
YES
5 2
1 8 2 3 4
NO
 */