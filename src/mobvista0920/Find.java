package mobvista0920;

import java.util.Scanner;
public class Find {

    public static int getFirst(int []nums, int target) {
        int idx = -1;
        int s = 0, e = nums.length-1;
        while (s <= e) {
            int m = (s + e) / 2;
            if (nums[m] >= target) {
                e = m - 1;
            } else {
                s = m + 1;
            }
            if (nums[m] == target) idx = m;
        }
        return idx;
    }

    public static int getLast(int []nums, int target) {
        int idx = -1;
        int s = 0, e = nums.length-1;
        while (s <= e) {
            int m = (s + e) / 2;
            if (nums[m] <= target) {
                s = m + 1;
            } else {
                e = m - 1;
            }
            if (nums[m] == target) idx = m;
        }
        return idx;
    }

    /**
     * 查找元素的第一个和最后一个的位置
     *
     * @param nums
     * @param target
     * @return 返回长度为2的数组记录开始和结束位置
     */
    public static int[] searchRange(int[] nums, int target) {
        return new int[]{getFirst(nums, target), getLast(nums, target)};
        //实现代码写在这里
        //return null;
    }

    //如下代码为预设代码，请勿动！
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int target = input.nextInt();
        input.nextLine();
        String line = input.nextLine();
        String[] slice = line.split(" ");
        int[] nums = new int[slice.length];
        for (int i = 0; i < slice.length; i++) {
            try {
                nums[i] = Integer.parseInt(slice[i]);
            } catch (NumberFormatException e) {
                System.out.print("测试用例错误！");
            }
        }
        int[] resultArray = searchRange(nums, target);
        if (resultArray != null && resultArray.length == 2) {
            System.out.print(resultArray[0] + " " + resultArray[1]);
        } else {
            System.out.print("结果错误！");
        }
        input.close();
    }
}
