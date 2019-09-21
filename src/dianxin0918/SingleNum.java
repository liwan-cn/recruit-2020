package dianxin0918;

/**
 * 落单的数
 */

import java.util.*;

public class SingleNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int res = 0;
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            res ^= sc.nextInt();
        }
        System.out.println(res);
    }
}
