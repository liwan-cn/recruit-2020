package kuaishou0330.Test3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =  sc.nextInt();
        int res = 0;
        while (n != 0){
            res += (n & 1);
            n >>>= 1;
        }
        System.out.println(res);
    }
}
