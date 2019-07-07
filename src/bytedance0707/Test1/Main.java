package bytedance0707.Test1;

import java.util.Arrays;
import java.util.Scanner;
/*
贪心策略：
1，如果田忌的最快马快于齐王的最快马，则两者比。
（因为若是田忌的别的马很可能就赢不了了，所以两者比）
2，如果田忌的最快马慢于齐王的最快马，则用田忌的最慢马和齐王的最快马比。
（由于所有的马都赢不了齐王的最快马，所以用损失最小的，拿最慢的和他比）
3，若相等，则比较田忌的最慢马和齐王的最慢马
3.1，若田忌最慢马快于齐王最慢马，两者比。
（田忌的最慢马既然能赢一个就赢呗，而且齐王的最慢马肯定也得有个和他比，所以选最小的比他快得。）
3.2，其他，则拿田忌的最慢马和齐王的最快马比。
（反正所有的马都比田忌的最慢马快了，所以这匹马必输，选贡献最大的，干掉齐王的最快马）
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []a = new int[n];
        int []b = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < b.length; i++) {
            b[i] = sc.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        //System.out.println(Arrays.toString(a));
        int res = 0;
        for (int as = 0, bs = 0, ae = n-1, be = n-1; as <= ae && bs <= be; ){
            if (a[ae] > b[be]) {
                ae --; be --;
                res ++;
            } else if (a[ae] < b[be]){
                as ++; be --;
                res--;
            } else {
                if (a[as] > b[bs]) {
                    as ++; bs ++;
                    res ++;
                } else if (a[as] < b[bs]){
                    as ++; be--;
                    res --;
                } else {
                    if (a[as] < b[be]) res --;
                    as ++; be --;
                }
            }
            //System.out.println(res);
            //System.out.println(as + "," +  ae + "," + bs + "," + be);
        }
        System.out.println(res);

    }
}
