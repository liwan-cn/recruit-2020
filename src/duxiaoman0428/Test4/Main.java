package duxiaoman0428.Test4;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] ca = sc.next().toCharArray();
        Set<Character> set = new HashSet<>();
        int cnt = 0;
        //System.out.println(ca);
        for (int s = 0, e = ca.length - 1; s < e; s++, e--){
            if(ca[s] != ca[e]) {
                cnt ++;
                set.add(ca[s]);
                set.add(ca[e]);
            }
        }
        if (cnt == 0){
            System.out.println("YES");
        } else if (cnt == 2){
            if (set.size() == 2)
                System.out.println("YES");
            else
                System.out.println("NO");
        } else {
            System.out.println("NO");
        }
    }
}
