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
            for (int i = 1; i < n; i++) {
                int tmp = sc.nextInt();
                int f = (int)Math.sqrt(i);
                if (f * f == i) {
                    System.out.print(tmp + " ");
                }
            }
            System.out.println(sc.nextInt());
        }
    }
}
