package kuaishou0825.Test2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(func(s));
    }
    public static int func(String s) {
        int []flag = new int[128];
        int begin = 0, end = 0, res = 0, cnt = 0;
        int l = s.length();
        while (end < l){
            if (flag[s.charAt(end)] == 0){
                flag[s.charAt(end++)] ++;
                res = Math.max(res, ++cnt);
            } else {
                flag[s.charAt(begin++)] --;
                cnt --;
            }
        }
        return res;
    }
}
