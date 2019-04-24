package meituan0423.Test1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        Map<Integer, Integer> whiteMap = new HashMap<>();
        Map<Integer, Integer> blackMap = new HashMap<>();
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                int tmp = sc.nextInt();
                if (((i + j) & 1) == 0) whiteMap.put(tmp, whiteMap.getOrDefault(tmp, 0) + 1);
                else blackMap.put(tmp, blackMap.getOrDefault(tmp, 0) + 1);
            }
        }
        int wMaxK1 = 0, wMaxK2 = 0; //白块第一大和第二大的Key
        int wMaxV1 = 0, wMaxV2 = 0; //白块第一大和第二大的Value
        for (Map.Entry<Integer, Integer> e: whiteMap.entrySet()){
            if (e.getValue() >= wMaxV1){
                wMaxK2 = wMaxK1; wMaxV2 = wMaxV1;
                wMaxK1 = e.getKey(); wMaxV1 = e.getValue();
            } else if(e.getValue() > wMaxV2){
                wMaxK2 = e.getKey(); wMaxV2 = e.getValue();
            }
        }
        int bMaxK1 = 0, bMaxK2 = 0; //黑块第一大和第二大的Key
        int bMaxV1 = 0, bMaxV2 = 0; //黑块第一大和第二大的Value
        for (Map.Entry<Integer, Integer> e: blackMap.entrySet()){
            if (e.getValue() >= bMaxV1){
                bMaxK2 = bMaxK1; bMaxV2 = bMaxV1;
                bMaxK1 = e.getKey(); bMaxV1 = e.getValue();
            } else if(e.getValue() > bMaxV2){
                bMaxK2 = e.getKey(); bMaxV2 = e.getValue();
            }
        }

        if (wMaxK1 != bMaxK1){
            System.out.println(m * n - wMaxV1 - bMaxV1);
        }else{
            System.out.println(m * n - Math.max(wMaxV2 + bMaxV1, bMaxV2 + wMaxV1));
        }
    }
}

/*
3 3
1 1 1
1 1 1
1 1 1

3 3
1 1 1
1 5 1
1 1 1
 */