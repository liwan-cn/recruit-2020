package ByteDance0414.Test2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []h = new int[n];
        for (int i = 0; i < h.length; i++) {
            h[i] = sc.nextInt();
        }
        int res = 0;
        for (int i = h.length - 1; i >= 0; i--) {
            res = (res + h[i] + 1) >> 1;
        }
        System.out.println(res);
    }
}
