package qianxin0909.Test1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = (1 << (sc.nextInt())) - 1;
        //System.out.println(n);
        int []arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int l = sc.nextInt(), h = sc.nextInt();
        if (l > h) {
            int t = l; l = h; h = t;
        }

        boolean lf = false, hf = false;
        for (int i = 0; i < n; i++) {
            if(arr[i] == l) lf = true;
            if(arr[i] == h) hf = true;
        }

        if (lf && hf) {
            int s = 1;
            while ((arr[s-1] - l) * (arr[s-1] - h) > 0)
                s = l < arr[s-1] ? s * 2 : s * 2 + 1;
            System.out.println(arr[s-1]);
        } else {
            System.out.println(-1);
        }


    }
}
/*
4
9 6 15 2 -1 12 25 -1 -1 -1 -1 -1 -1 20 37
12 20
*/