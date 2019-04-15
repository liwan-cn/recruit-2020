package kuaishou0413.Test1;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        String t = sc.next();
        String []ss = t.split(",");
        String s1 = ss[0], s2 = ss[1];
        System.out.println(getCommonStrLength(s1, s2));
    }
    static  int getCommonStrLength(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        int len1 = str1.length();
        int len2 = str2.length();
        String min = null;
        String max = null;
        String target = null;
        min = len1 <= len2 ? str1 : str2;
        max = len1 >  len2 ? str1 : str2;
        for (int i = min.length(); i >= 1; i--) {
            for (int j = 0; j <= min.length() - i; j++) {
                target = min.substring(j, j + i);
                for (int k = 0; k <= max.length() - i; k++) {
                    if (max.substring(k,k + i).equals(target)) {
                        return i;
                    }
                }
            }
        }
        return 0;
    }
}
