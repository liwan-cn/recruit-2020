package dianxin0918;

/**
 * 同构字符串
 */

import java.util.*;

public class Isomorphic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.next();
        String []st = line.split(";");
        System.out.println(isIsomorphic(st[0], st[1]) ? "True" : "False");
    }

    public static boolean isIsomorphic(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        int[] m = new int[512];
        for (int i = 0; i < s1.length(); i++) {
            if (m[s1.charAt(i)] != m[s2.charAt(i)+256]) return false;
            m[s1.charAt(i)] = m[s2.charAt(i)+256] = i+1;
        }
        return true;
    }
}
