package kuaishou0825.Test1;

import java.util.*;

public class Main {
    static class Node {
        String name = null;
        boolean isV = false;
        public Node(String name, boolean isV) {
            this.name = name;
            this.isV = isV;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        Node []rec = new Node[m];
        int cnt = 0 ,pre = -10000;
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            String name = sc.next();
            Node tmp =  new Node(name, name.charAt(0) == 'V');
            if (cnt - pre >= n && !q.isEmpty()) {
                rec[cnt] = q.poll();
                pre = cnt;
                cnt ++;
            }
            if (tmp.isV) {
                rec[cnt++] = tmp;
            } else {
                q.offer(tmp);
            }
        }
        while (cnt - pre >= n && !q.isEmpty()) {
            rec[cnt] = q.poll();
            pre = cnt;
            cnt ++;
        }
        System.out.println(cnt);
        for (int i = 0; i < cnt; i++) {
            System.out.println(rec[i].name);
        }

    }
}

/*
3
10
V_0
V_1
V_2
P_3
P_4
P_5
V_6
P_7
V_8
V_9
 */