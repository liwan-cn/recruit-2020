package alibaba0317.Test1;

public class Main {

    public static void main(String[] args) {
        // write your code here
        String s1 = "1121", s2 = "212";
        System.out.println(add(s1, s2, 3));
    }
    private static String add(String s1, String s2, int base){
        s1 = new StringBuffer(s1).reverse().toString();
        s2 = new StringBuffer(s2).reverse().toString();
        StringBuffer res = new StringBuffer();
        int carry = 0;
        int i = 0;
        for (i = 0; i < s1.length() && i < s2.length();i++){
            res.append((s1.charAt(i) - '0' + s2.charAt(i) - '0' + carry) % base  + "");
            carry = (s1.charAt(i) - '0' + s2.charAt(i) - '0' + carry) / base;
        }
        for (; i < s1.length(); i++){
            res.append((s1.charAt(i) - '0' + carry) % base  + "");
            carry = ( s1.charAt(i) - '0' + carry) / base;
        }
        for (; i < s2.length(); i++){
            res.append((s2.charAt(i) - '0' + carry) % base + "");
            carry = ( s2.charAt(i) - '0' + carry) / base;
        }
        if (carry != 0) {
            res.append(carry + "");
        }
        return res.reverse().toString();
    }
}
