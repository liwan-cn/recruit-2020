package other;

public class Main {
    public static void main(String[] args) {
        for(int i = 1; i < 1000; i++) {
            System.out.println(i + ":" + f1(i, 3) + "," + f2(i));
        }
        System.out.println(1000000000 + ":" + f1(1000000000, 3));
        System.out.println(1000000000 + ":" + f2(1000000000));
        System.out.println(1000000000 + ":" + f2(1000000000));

    }
    static int f2(int n) {
        int s = 1, res = 1;
        while (s < n){
           if (s == res) {
               int t = (s + 1) / 2;
               s += t;
               res = -1 + 3 * t;
           } else {
               int t = (s + 2) / 2;
               s += t;
               res = -2 + 3 * t;
           }

        }
        return res - 3 * (s-n);
    }
    static int f1(int n, int m) {
        int r = 0;//即f(1)=0;
        for(int i = 2; i <= n; i++)
            r = (r + m) % i;//即f(i)=[f(i-1)+m]%n;
        return r + 1; //即f(n)=1；
    }

}
