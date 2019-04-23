package tencent0407.Test3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k= sc.nextInt();
        int []arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int res = 0, index = -1;
        for (int i = 0; i < k; i++){
            if (arr[n-1] - res <= 0){
                System.out.println(0);
                continue;
            }
            index = findNext(arr, index+1, res);
            System.out.println(arr[index]-res);
            res = arr[index];

        }
    }
    private static int findNext(int []arr, int start, int res){
        while (arr[start] - res == 0){
            start++;
        }
        return start;
    }
}
