package netease0803.Test3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        boolean j = false, o = false;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] % 2 == 0){
                o = true;
            } else {
                j = true;
            }
        }
        if (o && j) {
            Arrays.sort(arr);
        }
        for (int i = 0; i < arr.length; i++) {
            if (i == 0){
                System.out.print(arr[i]);
            }else {
                System.out.print(" " + arr[i]);
            }
        }
        System.out.println();
    }
}
