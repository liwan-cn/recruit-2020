package tujia0906.Test2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt(), m = sc.nextInt();
        int []w = new int[s], v = new int[s];

        for (int i = 0; i < s; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        int []f = new int[m+1];

        for (int i = 0; i < s; i++){
            for (int j = m; j >= w[i]; j--){
                f[j] = Math.max(f[j], f[j - w[i]] + v[i]);
            }
        }

        System.out.println(f[m]);
    }
}
