package kuaishou0825.Test3;

import java.util.*;

public class Main {
    static class Fitness{
        int id;
        int dis, effect;
        public Fitness(int id, int dis, int effect) {
            this.id = id;
            this.dis = dis;
            this.effect = effect;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][]arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr[i][1] = sc.nextInt();
        }
        Arrays.sort(arr, (o1, o2) -> (o1[0] - o2[0]));
        boolean []f = new boolean[n];
        int max = 0;
        PriorityQueue<Fitness> left = new PriorityQueue<>((f1, f2) -> (f2.effect - f1.effect));
        PriorityQueue<Fitness> right = new PriorityQueue<>((f1, f2) ->
                ((f2.effect + (f2.dis << 1)) - (f1.effect + (f1.dis << 1))));
        for (int i = 0; i < n; i++) {
            Fitness fitness = new Fitness(i, arr[i][0], arr[i][1]);
            //left.offer(fitness);
            right.offer(fitness);
        }
        int res = 0;
        for (int k = 0; k < n; k++) {
            while (!left.isEmpty() && f[left.peek().id]) left.poll();
            while (!right.isEmpty() && (f[right.peek().id] || right.peek().dis <= max)) right.poll();
            if (!left.isEmpty() && !right.isEmpty()) {
                Fitness l = left.peek(), r = right.peek();
                if (l.effect > r.effect + (r.dis - max) * 2) {
                    f[l.id] = true;
                    left.poll();
                } else {
                    f[r.id] = true;
                }
            } else if (!right.isEmpty()){

            } else {

            }

        }
    }
}
/*
5
1 2 3 4 5
1 1 1 1 1

11
12
13
14
15

 */
