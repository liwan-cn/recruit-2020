package sohu0829.Test2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = (int)Math.sqrt(n * 2);
        if (t * (t + 1) == n * 2) {
            System.out.println(t);
        } else {
            System.out.println(t + 2);
        }
    }
}
