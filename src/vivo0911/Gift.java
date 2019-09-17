package vivo0911;

public class Gift {
    public static void main(String[] args) {
        System.out.println(minBox("(((0)))"));
        System.out.println(minBox("(()(()((()(0)))))"));
    }
    private static int minBox(String line) {
        int min = Integer.MAX_VALUE;
        int l = 0, r = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '(') l++;
            else if(line.charAt(i) == ')') r++;
            else min = Math.min(l - r, min);
        }
        return min;
    }
}
