package duxiaoman0428.Test3;

import java.util.*;

public class Main {
    static class Node{
        int x;
        int flag;
        Node(int x, int flag){
            this.x = x; this.flag = flag;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = 0;
        Node []nodes = new Node[n<<1];
        for (int i = 0; i < n; i++){
            nodes[(i << 1)] = new Node(sc.nextInt(), 1);
            nodes[(i << 1) + 1] = new Node(sc.nextInt(), -1);
        }
        Arrays.sort(nodes, (o1, o2) -> (o1.x == o2.x ? o1.flag - o2.flag : o1.x - o2.x));
        int now = 0;
        for (int i = 0; i < nodes.length; i++) {
            now += nodes[i].flag;
            max = Math.max(now, max);
        }
        System.out.println(max);
    }
}
