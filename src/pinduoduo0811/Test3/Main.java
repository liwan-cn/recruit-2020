package pinduoduo0811.Test3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), s =sc.nextInt();
        if ((1+n) * n /2 > s) {
            System.out.println(0);
        }
    }
}
