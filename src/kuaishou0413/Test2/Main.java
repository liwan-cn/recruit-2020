package kuaishou0413.Test2;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String t = sc.next();
        int res = 0;
        String []ss = t.split(",");
        for (String s : ss){
            res += Integer.valueOf(s);
        }
        System.out.println((1+Integer.valueOf(ss[ss.length-1])) * Integer.valueOf(ss[ss.length-1]) / 2 - res);
    }
}
