package xiaomi0826.Test2;

/**
 * 神奇数字
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            for (int i = 1, cnt = 1, f = cnt * cnt; i < n; i++) {
                int tmp = sc.nextInt();
                if (f == i) {
                    cnt ++;
                    f = cnt * cnt;
                    System.out.print(tmp + " ");
                }
            }
            System.out.println(sc.nextInt());
        }
    }
}
