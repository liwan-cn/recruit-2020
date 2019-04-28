package duxiaoman0428.Test1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0){
            long num = sc.nextInt();
            long tmp = num;
            boolean H = false;
            boolean G = true;
            while (tmp != 0){
                if (tmp % 10 == 0){
                    G = false;
                }else if (num % (tmp % 10) == 0){
                    H = true;
                } else {
                    G = false;
                }
                tmp /= 10;
            }
            if (G) System.out.println("G");
            else if (H) System.out.println("H");
            else System.out.println("S");
        }
    }
}
