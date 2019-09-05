package tencent0901.Test5;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = 0;
        for (int i = 0; i < n; i ++) {
            int x1= sc.nextInt(), y1 = sc.nextInt(), x2 = sc.nextInt(), y2 = sc.nextInt();
            int t = sc.nextInt();
            max = Math.max((x2 - x1) * (y2 - y1), max);
        }
        System.out.println(max);
    }
}
