package Tencent0407.Test2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long res = 0, need = 0;
        int n =sc.nextInt();
        for (int i = 0; i < n; i++){
            need += sc.nextInt();
            res += Math.abs(need);
        }
        System.out.println(res);
    }
}
