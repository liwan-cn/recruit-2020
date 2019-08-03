package netease0803.Test4;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next(), t = sc.next();
        String rs = res(s);

        String rt = res(t);
        int sl = s.length(), tl = t.length();
        int slr = rs.length(), tlr = rt.length();
        String r = sc.next();
        boolean []dp= new boolean[r.length() + 1];
        dp[0] = true;
        for (int i = 1, l = r.length(); i <= l; i++){
            boolean sf = false;
            if (i - sl >= 0) {
                String s1 = r.substring(i-sl, i);
                sf = dp[i-sl] && s1.equals(s);
            }
            boolean tf = false;
            if (i - tl >= 0) {
                String t1 = r.substring(i-tl, i);
                tf = dp[i-tl] && t1.equals(t);
            }

            boolean sfr = false;
            if (i - slr >= 0) {
                String s1r = r.substring(i-slr, i);
                sfr = dp[i-slr] && s1r.equals(rs);
            }
            boolean tfr = false;
            if (i - tlr >= 0) {
                String t1r = r.substring(i-tlr, i);
                tfr = dp[i-tlr] && t1r.equals(rt);
            }
            dp[i] = sf || tf || sfr || tfr;
        }
        //System.out.println(Arrays.toString(dp));
        System.out.println(dp[r.length()] ? "YES" : "NO");
    }
    public static String res(String s) {
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0'){
                start = i;
                break;
            }
        }
        s = s.substring(start, s.length());
        char [] ca = s.toCharArray();
        for (int i = 0; i < ca.length; i++) {
            if (ca[i] == '0') ca[i] = '1';
            else ca[i] = '0';
        }
        return new String(ca);
    }
}
