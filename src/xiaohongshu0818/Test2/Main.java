package xiaohongshu0818.Test2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]= sc.nextInt();
        }
        int cnt = 0;
        if (n == 1) {
            if (arr[0] != 0) cnt ++;
            System.out.println(arr[0] + " " + cnt);
            return;
        }
        if (n == 2) {
            if (Math.max(arr[0], arr[1]) != 0) cnt ++;
            System.out.println(Math.max(arr[0], arr[1]) + " " + cnt);
            return;
        }
        int maxN = arr[0], maxY = Math.max(arr[0], arr[1]);
        int cntN = 0, cntY = 0;
        if (maxN != 0) cntN++;
        if (maxY != 0) cntY++;

        for(int i = 2; i < n; i++){
            int tmp = maxY;
            int tmpCnt = cntY;
            if (arr[i] + maxN > maxY) cntY = cntN + 1;
            maxY = Math.max(arr[i] + maxN, maxY);
            maxN = tmp;
            cntN = tmpCnt;
        }
        System.out.println(maxY + " " + cntY);
    }
}
