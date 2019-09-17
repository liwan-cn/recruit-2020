package baidu0917;

import java.util.*;

/**
 * 能不能完成工作
 * 每个工作所需要耗费的时间, 以及截至时间
 */
public class Work {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int [][]arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }
            Arrays.sort(arr, (o1, o2) -> (o1[1]-o2[1]));
            int sum = 0;
            boolean f = true;
            for (int i = 0; i < n; i++){
                sum += arr[i][0];
                if (sum > arr[i][1]){
                    f = false;
                    break;
                }
            }
            System.out.println(f ? "Yes" : "No");
        }
    }
}
/*
1
5
2 4
1 9
1 8
4 9
3 12
 */