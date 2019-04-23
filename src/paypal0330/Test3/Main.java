package paypal0330.Test3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double d = sc.nextDouble();
        int n = sc.nextInt();
        double [][]zuobiao = new double [n][2];
        for (int i = 0; i<n; i++){
            zuobiao[i][0] = sc.nextDouble();
            zuobiao[i][1] = sc.nextDouble();
        }
        boolean [][]w = new boolean[n][n];
        for (int i = 0; i < n; i++){
            for (int j = i +1; j< n;j++){
                boolean fl = f(zuobiao[i][0], zuobiao[i][1], zuobiao[j][0], zuobiao[j][1], d);
                w[i][j] = fl;
                w[j][i] = fl;
            }
        }
        boolean []v = new boolean[n];
        List<List<Integer>> re = new ArrayList<>();
        for (int i = 0; i<n; i++){
            if(!v[i]) {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                bfs(w, v,i,l);
                Collections.sort(l);
                re.add(l);
            }
        }
        Collections.sort(re, (o1, o2) -> o2.size()-o1.size());
        System.out.println(re);

    }
    private static boolean f(double x1, double y1, double x2, double y2, double d){
        double x = x1-x2, y=y1-y2;
        return x*x + y*y < d * d;
    }
    private static void bfs(boolean [][]w, boolean []v, int s, List<Integer> list){
        v[s] = true;
        for (int i = 0; i < w.length; i++){
            if(!v[i] && w[s][i]){
                list.add(i);
                bfs(w, v, i, list);
            }
        }
    }
}

