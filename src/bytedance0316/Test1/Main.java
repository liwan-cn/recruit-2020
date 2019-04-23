package bytedance0316.Test1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n  =  sc.nextInt();
        int res = 0;
        int remain =  1024 - n;
        res += remain / 64;

        remain %= 64;
        res  += remain / 16;

        remain %= 16;
        res += remain / 4;

        remain %= 4;
        res += remain;
        System.out.println(res);
    }
}
