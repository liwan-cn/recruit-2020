package bytedance0825.Test3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int [][]mat = new int[4][4];
        for (int  i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j ++) {
                mat[i][j] = sc.nextInt();
            }
        }
        if (t == 1) up(mat);
        else if (t == 2) down(mat);
        else if (t == 3) left(mat);
        else right(mat);
        for (int i = 0; i < 4; i++) {
            System.out.println(mat[i][0] + " " + mat[i][1] + " " + mat[i][2] + " " + mat[i][3]);
        }
    }
    /*
1
0 0 0 2
0 0 0 2
0 0 4 8
0 0 4 8
     */
    public static void up(int [][]mat) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (mat[j][i] == 0) continue;
                for (int k = j +1; k < 4; k++) {
                    if (mat[k][i] == 0) continue;
                    if (mat[j][i] == mat[k][i]) {
                        mat[j][i] <<= 1;
                        mat[k][i] = 0;
                        j = k;
                        //k = j = 0;
                    } else {
                        break;
                    }
                }
            }
            int t = 0;
            int []tmp = new int[4];
            for (int j = 0; j < 4; j++) {
                if (mat[j][i] != 0) {
                    tmp[t++] = mat[j][i];
                }
            }
            if (t != 4) {
                while(t < 4) tmp[t++] = 0;
            }
            for (int j = 0; j < 4; j ++) mat[j][i] = tmp[j];
        }
    }

    /*
2
0 0 0 2
0 0 0 2
0 0 4 8
0 0 4 8

2
0 0 0 0
0 0 2 2
0 2 8 8
2 4 2 16
     */
    public static void down(int [][]mat) {
        for (int i = 0; i < 4; i++) {
            for (int j = 3; j >=0; j--) {
                if (mat[j][i] == 0) continue;
                for (int k = j - 1; k >= 0; k--) {
                    if (mat[k][i] == 0) continue;
                    if (mat[j][i] == mat[k][i]) {
                        mat[j][i] <<= 1;
                        mat[k][i] = 0;
                        j = k;
                    } else {
                        break;
                    }
                }
            }
            int t = 3;
            int []tmp = new int[4];
            for (int j = 3; j >= 0; j--) {
                if (mat[j][i] != 0) {
                    tmp[t--] = mat[j][i];
                }
            }
            if (t != -1) {
                while(t >= 0) tmp[t--] = 0;
            }
            for (int j = 0; j < 4; j ++) mat[j][i] = tmp[j];
        }
    }

    /*
3
0 0 0 0
0 0 0 0
4 4 0 0
8 8 2 2
     */
    public static void left(int [][]mat) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (mat[i][j] == 0) continue;
                for (int k = j +1; k < 4; k++) {
                    if (mat[i][k] == 0) continue;
                    if (mat[i][j] == mat[i][k]) {
                        mat[i][j] <<= 1;
                        mat[i][k] = 0;
                        j = k;
                    } else {
                        break;
                    }
                }
            }
            int t = 0;
            int []tmp = new int[4];
            for (int j = 0; j < 4; j++) {
                if (mat[i][j] != 0) {
                    tmp[t++] = mat[i][j];
                }
            }
            if (t != 4) {
                while(t < 4) tmp[t++] = 0;
            }
            for (int j = 0; j < 4; j ++) mat[i][j] = tmp[j];
        }
    }

    /*
4
0 0 0 0
0 0 0 0
0 0 4 4
2 2 8 8
     */
    public static void right(int [][]mat) {
        for (int i = 0; i < 4; i++) {
            for (int j = 3; j >=0; j--) {
                if (mat[i][j] == 0) continue;
                for (int k = j - 1; k >= 0; k--) {
                    if (mat[i][k] == 0) continue;
                    if (mat[i][j] == mat[i][k]) {
                        mat[i][j] <<= 1;
                        mat[i][k] = 0;
                        j = k;
                    } else {
                        break;
                    }
                }
            }
            int t = 3;
            int []tmp = new int[4];
            for (int j = 3; j >= 0; j--) {
                if (mat[i][j] != 0) {
                    tmp[t--] = mat[i][j];
                }
            }
            if (t != -1) {
                while(t >= 0) tmp[t--] = 0;
            }
            for (int j = 0; j < 4; j ++) mat[i][j] = tmp[j];
        }
    }
}
