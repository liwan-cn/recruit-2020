package paypal0330.Test2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Integer> in = new HashMap<>();
        Map<Integer, List<Integer>> out = new HashMap<>();

        for(int i = 0; i <n;i++){
            String line = sc.next();
            String []t = line.split(",");
            int ini = Integer.valueOf(t[0]);
            int outi = Integer.valueOf(t[1]);

            if (out.get(ini) == null){
                out.put(ini, new ArrayList<>());
            }

            in.put(ini, in.getOrDefault(ini, 0));
            if(!out.get(ini).contains(outi)){
                in.put(outi, in.getOrDefault(outi, 0) + 1);
                out.get(ini).add(outi);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (Map.Entry<Integer, Integer> e: in.entrySet()){
            if (e.getValue() == 0)
                q.offer(e.getKey());
            if (e.getValue() > 1) System.out.println("Not a Tree");
        }
        boolean flag = false;
        while(!q.isEmpty()){
            int now = q.poll();
            for (Integer i:out.getOrDefault(now, new ArrayList<>())){
                q.offer(i);
            }
            if (!flag){
                System.out.print(now);
                flag = true;
            } else {
                System.out.print("," +now);
            }
            System.out.println();
        }
    }
}
