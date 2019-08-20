package bilibili0820.Test2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt(), w = sc.nextInt();
        int [][]image = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                image[i][j] = sc.nextInt();
            }
        }
        int m = sc.nextInt();
        double [][] kernel = new double[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                kernel[i][j] = sc.nextDouble();
            }
        }
        //double [][]res = new double[h-m+1][w-m+1];
        for (int i = 0; i <= h - m; i ++) {
            for (int j = 0; j <= w - m; j ++) {
                double t = 0.;
                for (int k = 0; k < m; k++) {
                    for (int l = 0; l < m; l ++) {
                        t += image[i+k][j+l] * kernel[k][l];
                    }
                }
                if (j == 0)
                    System.out.print((int)t);
                else
                    System.out.print(" " + (int)t);
            }
            System.out.println();
        }

    }
}
