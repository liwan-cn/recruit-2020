package Alibaba0412.Test1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double []arr = new double[n];
        for (int i = 0;i < n ; i++){
            arr[i] = sc.nextDouble();
        }
        double xm = 0, now = 1;
        for (int i = 0; i < 100; i++){
            if (i % 2 == 0){
                xm += now * arr[i % n];
            }
            now *= (1 - arr[i % n]);
        }
        BigDecimal b = new BigDecimal(xm);
        double f1 = b.setScale(4, RoundingMode.HALF_UP).doubleValue();
        System.out.println(String.format("%.4f", f1));
    }
}


