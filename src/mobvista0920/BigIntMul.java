package mobvista0920;

import java.util.Scanner;

public class BigIntMul {
    //实现代码写在这里
    public static String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int []res = new int[m+n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') *  (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + res[p2];
                res[p1] += sum /  10;
                res[p2] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int d : res) {
            if (!(sb.length() == 0 && d == 0)) sb.append(d);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    //如下代码为预设代码，请勿动！
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String num1 = input.nextLine();
        String num2 = input.nextLine();
        System.out.print(multiply(num1, num2));
        input.close();
    }
}
