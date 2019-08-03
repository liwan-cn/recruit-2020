package yuanfudao0803.Test1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t -- > 0) {
            String s = sc.next();
            Stack<Integer> stack = new Stack<>();
            StringBuilder tmp = new StringBuilder();
            for (int i = 0; i < s.length(); i++){
                if (s.charAt(i) == '(') {
                    stack.push(tmp.length());
                } else if (s.charAt(i) == ')') {
                    int j = i + 1;
                    while(j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                        j++;
                    }
                    int num = 1;
                    if (j == i + 1) {
                        num = 1;
                    } else {
                        num = Integer.valueOf(s.substring(i+1, j));
                    }
                    i = j - 1;
                    int start = stack.pop();
                    String item = tmp.substring(start);
                    StringBuilder items = new StringBuilder();
                    while (num -- > 0) {
                        items.append(item);
                    }
                    tmp = new StringBuilder(tmp.substring(0, start) + items.toString());
                } else {
                    tmp.append(s.charAt(i));
                }
            }
            //System.out.println(tmp);
            StringBuilder res = new StringBuilder("" + tmp.charAt(0));
            for (int i = 1; i < tmp.length(); i++) {
                if (tmp.charAt(i) >= '0' && tmp.charAt(i) <= '9') {
                    int j = i;
                    while(j < tmp.length() && tmp.charAt(j) >= '0' && tmp.charAt(j) <= '9') {
                        j++;
                    }
                    int num = Integer.valueOf(tmp.substring(i, j));
                    char c = tmp.charAt(i-1);
                    while (num -- > 1) {
                        res.append(c);
                    }
                    i = j - 1;
                } else {
                    res.append(tmp.charAt(i));
                }
            }
            System.out.println(res);
        }
    }
}

/*
(AB)3((YW)4N12)5Y9(A)3(GY)12
 */