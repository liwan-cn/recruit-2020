package tencent0817.Test3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        long m = sc.nextLong();
        long [][]arr = new long[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextLong();
        }
        for (int i = 0; i < n; i++) {
            arr[i][1] = sc.nextLong();
        }
        Arrays.sort(arr, (o1, o2) -> (int)(o1[0] - o2[0]));
        long res = arr[0][0];
        long preSum = arr[0][1];
        for (int i = 1; i < n; i++) {
            if (m <= 0) break;
            long add = Math.min(arr[i][0] - arr[i-1][0], m / preSum);
            res += add;
            m -= preSum * add;
            preSum += arr[i][1];
            if(add < arr[i][0] - arr[i-1][0]) break;
        }
        System.out.println(res);
    }
}
