package Tencent0310.Test4;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0){
            int n = sc.nextInt(), m = sc.nextInt();
            int xa1 = sc.nextInt(), ya1 = sc.nextInt();
            int xa2 = sc.nextInt(), ya2 = sc.nextInt();
            int xb1 = sc.nextInt(), yb1 = sc.nextInt();
            int xb2 = sc.nextInt(), yb2 = sc.nextInt();
            int blackCnt = blackCount(1, 1, n, m);
            blackCnt -= blackCount(xa1, ya1, xa2, ya2);
            blackCnt += (xb2 - xb1 + 1) * (yb2 - yb1 + 1) - blackCount(xb1, yb1, xb2, yb2);
            blackCnt += overlayBlackCount(xa1, ya1, xa2, ya2, xb1, yb1, xb2, yb2);
            System.out.println((n * m - blackCnt) + " " + blackCnt);
        }
    }
    private static int overlayBlackCount(int xa1, int ya1, int xa2, int ya2,
                                         int xb1, int yb1, int xb2, int yb2){
        int x1 = Math.max(xa1, xb1);
        int y1 = Math.max(ya1, yb1);
        int x2 = Math.min(xa2, xb2);
        int y2 = Math.min(ya2, yb2);
        if (x1 <= x2 && y1 <= y2){
            return blackCount(x1, y1, x2, y2);
        }
        return 0;
    }
    private static int blackCount(int x1, int y1, int x2, int y2){
        /*
        |-------|-------|
        |   a   |   b   |
        |-------|-------|
        |   c   |   d   |
        |-------|-------|
        左上角(1, 1) 右下角坐标(x, y) 的矩形中黑块数为(x * y) / 2;
        设整个大矩形区域内有 x 个
        d = x - (a + c) - (a + b) + a;
         */
        return ((x2 * y2) >> 1)
                - (((x1 - 1) * y2) >> 1)
                - ((x2 * (y1 - 1)) >> 1)
                + (((x1 - 1) * (y1 - 1)) >> 1);
    }
}
