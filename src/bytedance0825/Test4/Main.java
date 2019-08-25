package bytedance0825.Test4;

import java.util.*;

class UnionFind {

    private int[] root;
    private int count;

    public UnionFind(int size) {
        this.root = new int[size];
        this.count = size;
        Arrays.fill(this.root, -1);
    }

    public int count() {
        return count;
    }

    private int find(int x) {
        if (root[x] < 0) return x;
        return root[x] = find(root[x]);
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    public void union(int x, int y) {
        int xUnion = find(x);
        int yUnion = find(y);
        if (xUnion != yUnion) {
            if (root[xUnion] > root[yUnion]) {
                root[yUnion] += root[xUnion];
                root[xUnion] = yUnion;
            } else {
                root[xUnion] += root[yUnion];
                root[yUnion] = xUnion;

            }
            count--;
        }
    }
    public int max() {
        int max = 1;
        for (int i = 0; i < root.length; i++) {
            if (root[i] < 0) {
                max = Math.max(max, -root[i]);
            }
        }
        return max;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        int []arr = new int[n];
        UnionFind u = new UnionFind(n);
        //System.out.println("11111");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            for (int j = 0; j < i; j ++) {
                if (gcd(arr[j], arr[i]) > 1) {
                    u.union(i, j);
                }
            }
        }
        System.out.println(u.max());
    }

    public static int gcd(int a, int b) {
        if (a < b) {
            int t = a;
            a = b;
            b = t;
        }
        if (a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }
}
