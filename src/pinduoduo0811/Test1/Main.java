package pinduoduo0811.Test1;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  =sc.nextInt();
        int []arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        double min = Double.MAX_VALUE;
        for (int i = 0; i < arr.length-2; i++) {
            min = Math.min(min, fangca(arr[i],arr[i+1], arr[i+2]));
        }
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        System.out.println(df.format(min));
    }
    public static double fangca(int a, int b ,int c) {
        double mean = (a + b + c) / 3.0;
        //System.out.println(mean);
        return ((a-mean) * (a-mean) + (b-mean) * (b-mean) + (c-mean) * (c-mean)) / 3.0;
    }
}
