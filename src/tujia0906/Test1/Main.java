package tujia0906.Test1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        int m = sc.nextInt();
        StringBuilder sb = new StringBuilder(n);
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < sb.length() - 1; j++) {
                if (sb.charAt(j) < sb.charAt(j+1)){
                    cnt ++;
                    sb.delete(j, j+1);
                    break;
                }
            }
        }
        if (cnt != m) {
            System.out.println(sb.substring(0, sb.length()-(m-cnt)));
            return;
        }
        System.out.println(sb);
    }
}
