package sohu0829.Test1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(count(sc.nextInt(), sc.nextLong()));
    }
    public static long count(int digit, long n) {
        long except0 = 0;
        long base = 1, k = 1, t = n;
        while (t >= 10) {
            t /= 10;
            base *= 10;
            k++;
            except0 += base;
        }
        if (digit == 0) return cal(n, digit, base, k) - except0;
        return cal(n, digit, base, k);
    }
    public static long cal(long n, int digit, long base, long k) {
        if (n < digit) return 0;
        if (n < 10) return 1;
        long first = n / base;
        if (first < digit) {
            return 0 + (base / 10 * first *(k-1)) + cal(n % base, digit, base/10, k-1);
        } else if (first == digit) {
            return (n % base + 1) + (base / 10 * first *(k-1)) + cal(n % base, digit, base/10, k-1);
        } else {
            return base + (base / 10 * first *(k-1)) + cal(n % base, digit, base/10, k-1);
        }
    }
}
