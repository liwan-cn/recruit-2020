package vivo0911;

/*
二维费用背包
 */
import java.util.*;

public class TwoDimBag {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(), T = sc.nextInt();
        String line = sc.next();
        String []items = line.split("#");
        int [][]f = new int[V+1][T+1];
        int []v = new int[items.length];
        int []w = new int[items.length];
        int []g = new int[items.length];
        for (int i = 0; i < items.length; i++) {
            String []item = items[i].split(",");
            w[i] = Integer.valueOf(item[0]);
            g[i] = Integer.valueOf(item[1]);
            v[i] = Integer.valueOf(item[2]);
        }
        for (int i = 0; i < items.length; i++)
            for (int j = V; j >= w[i]; j--)
                for (int k = T; k >= g[i]; k--)
                    f[j][k] = Math.max(f[j][k], f[j - w[i]][k - g[i]] + v[i]);

        System.out.println(f[V][T]);

    }
}
/*
15 10 5,1,1000#2,3,3000#5,2,15000#10,4,16000
 */