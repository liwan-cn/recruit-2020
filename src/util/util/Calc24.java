package util.util;

import java.util.*;

public class Calc24 {

    /* 生成全排列*/
    private static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        permuteRemain(lists, nums, 0);
        return lists;
    }
    private static void permuteRemain(List<List<Integer>> lists, int[] nums, int start){
        if (start == nums.length - 1) {
            List<Integer> tmp = new ArrayList<>();
            for(int item : nums){
                tmp.add(item);
            }
            lists.add(tmp);
        } else {
            for (int i = start, end = nums.length - 1; i <= end; i++) {
                if (!swapAccepted(nums, start, i)) continue;
                swap(nums, start, i);
                permuteRemain(lists, nums, start + 1);
                swap(nums, start, i);
            }
        }
    }
    private static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    private static boolean swapAccepted(int[] nums, int start, int end) {
        for (int i = start; i < end; i++) {
            if (nums[i] == nums[end]) {
                return false;
            }
        }
        return true;
    }
    //生成全排列结束

    //逆波兰式
    private static double calc(Object[] reversePolish) {
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < 7; i++) {
            if (reversePolish[i] instanceof Integer) {
                stack.push(new Double((Integer) reversePolish[i]));
            } else {
                String op = (String) reversePolish[i];
                if (op.equals("+")){
                    double second = stack.pop(), first = stack.pop();
                    stack.push (first + second);
                } else if (op.equals("-")){
                    double second = stack.pop(), first = stack.pop();
                    stack.push (first - second);
                } else if (op.equals("*")){
                    double second = stack.pop(), first = stack.pop();
                    stack.push (first * second);
                } else if (op.equals("/")){
                    double second = stack.pop(), first = stack.pop();
                    stack.push (first / second);
                }

            }

        }
        return (double) stack.pop();
    }

    // 算24点 并将结果的逆波兰式转换为 四则运算表达式
    private static String trans(Object[] rP){
        Stack<Integer> stack = new Stack<>();
        int flag = 0;
        String newStr = "";
        for (int i = 0; i < rP.length; i++){

            //是字符元素就压栈
            if (rP[i] instanceof Integer) {
                stack.push((Integer) rP[i]);
            }else if(((String) rP[i]).equals("+") || ((String) rP[i]).equals("-")){
                //加减和乘除分开，加减要多加括号
                if (flag == 0) {
                    //理解思路是处理完的再压栈，但是这里是要打印出字符串，所以采用 标志位。
                    //如果标志位为0，就用栈中的对新字符串作用，如果标志位为1，
                    //说明刚才算出的字符串被压栈后又有新的字符压入它的上面，所以要用才算出的字符串对新压入的字符进行处理.
                    if (newStr.length() == 0) {
                        //开始时字符串为0，取两个栈中的元素.
                        int stackStrFirst = stack.pop();
                        int stackStrSecond = stack.pop();
                        newStr= newStr + "("+stackStrSecond + rP[i] + stackStrFirst+")";
                        flag++;
                    }else{
                        //new 的字符串有元素。取一个栈顶的元素。
                        int stackStr = stack.pop();
                        newStr = "(" + newStr + rP[i] + stackStr +")";
                    }
                }else{
                    //标志位位1，弹出后直接被上一次作用的字符串操作。
                    int stackStr = stack.pop();
                    newStr = "(" + newStr + rP[i] + stackStr + ")";
                    flag--;
                }

            }else if(((String) rP[i]).equals("*") || ((String) rP[i]).equals("/")){
                //处理逻辑和+- 的相同，只不过在处理的时候，不用加括号
                if (flag == 0) {
                    if (newStr.length() == 0) {
                        int stackStrFirst = stack.pop();
                        int stackStrSecond = stack.pop();
                        newStr= newStr + stackStrSecond + rP[i] + stackStrFirst;
                        flag++;
                    }else{
                        int stackStr = stack.pop();

                        newStr = "" + newStr  + rP[i] + stackStr;
                    }
                }else{
                    int stackStr = stack.pop();
                    newStr = "" + stackStr + rP[i] + newStr;
                    flag--;
                }
            }


        }
        if (newStr.charAt(0)=='(' && newStr.charAt(newStr.length()-1) ==')' ) {
            newStr = newStr.substring(1, newStr.length()-1);
        }
        return newStr;
    }

    private static Object [] calc24Point(List<Integer> nums){
        String[] opts = {"+","-","*","/"};
        Object [] stack = new Object[7];
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                for(int k=0;k<4;k++){
                    // a b + c + d +  (((a+b)+c)+d)
                    stack[0] = nums.get(0);
                    stack[1] = nums.get(1);
                    stack[2] = opts[i];
                    stack[3] = nums.get(2);
                    stack[4] = opts[j];
                    stack[5] = nums.get(3);
                    stack[6] = opts[k];
                    if (calc(stack) == 24){
                        return stack;
                    }
                    // a b + c d + +  ((a+b)+(c+d))
                    stack[3] = nums.get(2);
                    stack[4] = nums.get(3);
                    stack[5] = opts[j];
                    if (calc(stack) == 24){
                        return stack;
                    }
                    // a b c + d + +  (a+((b+c)+d))
                    stack[2] = nums.get(2);
                    stack[3] = opts[i];
                    stack[4] = nums.get(3);
                    if (calc(stack) == 24){
                        return stack;
                    }
                    // a b c + + d +  ((a+(b+c))+d)
                    stack[3] = opts[i];
                    stack[4] = opts[j];
                    stack[5] = nums.get(3);
                    if (calc(stack) == 24){
                        return stack;
                    }
                    // a b c d + + +  (a+(b+(c+d)))
                    stack[3] = nums.get(3);
                    stack[4] = opts[i];
                    stack[5] = opts[j];
                    if (calc(stack) == 24){
                        return stack;
                    }
                }
            }
        }
        return null;
    }


    private static String genStr(int [] nums){
        Object[] res = null;
        for (List<Integer> list :permuteUnique(nums)){
            res = calc24Point(list);
            if (res != null){
                break;
            }
        }
        if (res == null) return null;
        return trans(res);
    }


}