package kuaishou0825.Test4;

import java.util.*;

public class Main {
    static class D{
        int a1 = 0;
        int a0 = 0;
        public D(int a1, int a0) {
            a1 = a1;
            a0 = a0;
        }
        public String toString() {
            return a1 + " * X + " + a0;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.next();
        String []lr = line.split("=");
        D l = getSum(lr[0]) ,r =  getSum(lr[1]);
        if (l.a1 == r.a1 && l.a0 == r.a0) {
            System.out.println(-1);
        } else if ((r.a0 - l.a0) % (l.a1 - r.a1) == 0) {
            System.out.println((r.a0 - l.a0) / (l.a1 - r.a1));
        } else {
            System.out.println(-1);
        }
//        System.out.println(l);
//        System.out.println(r);
    }
    public static D getSum(String line) {
        D d = new D(0, 0);
        boolean f = true;
        int s = 0;
        for (int i = 0; i <= line.length(); i++) {
            if (i == line.length() || line.charAt(i) == '+' || line.charAt(i) == '-') {
                String item = line.substring(s, i);
                D cnt = getCnt(item);
                d.a1 += f ? cnt.a1 : -cnt.a1;
                d.a0 += f ? cnt.a0 : -cnt.a0;
                if (i < line.length())
                    f = line.charAt(i) == '+';
                //System.out.println(item);
                s = i + 1;
            }
        }
        return d;
    }
    public static D getCnt(String item) {
        String []t = item.split("\\*");
        D d = new D(0, 0);
        if (t.length == 2) {
            if (t[0].equals("X") || t[1].equals("X")){
                if (!t[0].equals("X")) d.a1 = Integer.valueOf(t[0]);
                if (!t[1].equals("X")) d.a1 = Integer.valueOf(t[1]);
            } else {
                d.a0 = Integer.valueOf(t[0]) * Integer.valueOf(t[1]);
            }
        } else {
            if (t[0].equals("X")) d.a1 = 1;
            else d.a0 = Integer.valueOf(t[0]);
        }
        return d;
    }

}

/*
2*X=6
3

X+2*X=3*X
-1
 */