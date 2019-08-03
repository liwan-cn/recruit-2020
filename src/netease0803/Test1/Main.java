package netease0803.Test1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++){
            int tmp = n - sc.nextInt() + 1;
            if (i == 1) {
                System.out.print(tmp);
            } else {
                System.out.print(" " + tmp);
            }
        }
        System.out.println();
    }
}
