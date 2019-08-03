package netease0803.Test2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int []arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            for (int i = 2; i < arr.length; i++){
                if (arr[i] > arr[i-1] + arr[i-2]){
                    System.out.println("NO");
                    return;
                }
            }
            System.out.println("YES");
        }
    }
}
