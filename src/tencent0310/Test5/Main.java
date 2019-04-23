package tencent0310.Test5;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = sc.nextInt();
        for (int i = 1; i <=n ; i++){
            int tmp = sc.nextInt();
            if (i >= 2){
                Map.Entry<Integer, Integer> e1 = map.floorEntry(tmp);
                Map.Entry<Integer, Integer> e2 = map.ceilingEntry(tmp);
                int min = Integer.MAX_VALUE, p = -1;
                if (e1 != null){
                    min = Math.abs(tmp - e1.getKey());
                    p = e1.getValue();
                }
                if (e2 != null){
                    if (Math.abs(tmp - e2.getKey()) < min){
                        min = Math.abs(tmp - e2.getKey());
                        p = e2.getValue();
                    }
                }
                System.out.println(min + " " + p);
            }
           map.put(tmp, i);
        }
    }
}
