package yuanfudao0916;
import java.util.*;

public class Mat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int [][]mat = new int[m][n];
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        List<Integer> list = travel(mat);
        for (int i = 0; i < list.size(); i++) {
            if (i != 0) {
                System.out.print(" ");
            }
            System.out.print(list.get(i));
        }
        System.out.println();
    }
    public static  List<Integer> travel(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix.length == 0) {
            return res;
        }
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd){
            for (int i = rowBegin; i <= rowEnd; i ++)
                res.add(matrix[i][colBegin]);
            colBegin ++;

            for (int j = colBegin; j <= colEnd; j ++)
                res.add(matrix[rowEnd][j]);
            rowEnd--;

            if (colBegin <= colEnd)
                for (int i = rowEnd; i >= rowBegin; i --)
                    res.add(matrix[i][colEnd]);
            colEnd --;

            if (rowBegin <= rowEnd)
                for (int j = colEnd; j >= colBegin; j --)
                    res.add(matrix[rowBegin][j]);
            rowBegin ++;
        }
        return res;
    }
}
