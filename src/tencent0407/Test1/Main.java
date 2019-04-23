package tencent0407.Test1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int cnt  = 0;
        while (cnt < k){
            if (n == 1) break;
            n = n - n / 2;
            cnt ++;
        }
        System.out.println(cnt + n);
    }
}
