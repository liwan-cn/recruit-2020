package bilibili0820.Test1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int []ret = new int[s.length()+1];
        ret[0] = 1;
        if (s.charAt(0) != '0') {
            ret[1] = 1;
        }
        for (int i = 1; i < s.length(); i++) {
            boolean si =  (s.charAt(i) != '0');
            ret[i+1] += si ? ret[i] : 0;
            int tmp = (s.charAt(i-1) - '0') * 10 + s.charAt(i) - '0';
            boolean bi = (tmp >= 10 && tmp <= 26);
            ret[i+1] += bi ? ret[i-1] : 0;
        }
        System.out.println(ret[s.length()]);
    }
}
