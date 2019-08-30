package alibaba0830.Test2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        List<Integer> L = new ArrayList<>();
        int sum = 0;
        while (sc.hasNextInt()) {
            int t = sc.nextInt();
            L.add(t);
        }

        int []ll = new int[L.size()];
        for (int i = 0; i < ll.length; i++) {
            ll[i] = L.get(i);
        }
        Arrays.sort(ll);
        for (int i = m * 2 + 2; i <= sum; i++) {
            for (List<Integer> list : combinationSum2(ll, i)){
                if (canPartition(list, m)){
                    System.out.println(i + ".0");
                    return;
                }
            }
        }

        System.out.println("-1.0");
    }


    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        selectNext(lists, new ArrayList<>(), candidates, target, 0);
        return lists;
    }

    private static void selectNext(List<List<Integer>> lists, List<Integer> list, int [] nums, int target, int start){
        if (target < 0) return;
        if (target == 0) {
            lists.add(new ArrayList<>(list));
        } else {
            for (int i = start, len = nums.length; i < len; i++){
                if(i > start && nums[i] == nums[i-1]) continue;
                list.add(nums[i]);
                selectNext(lists, list, nums, target - nums[i], i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    public static boolean canPartition(List<Integer> nums, int m) {
        int sum = 0;
        for (int num : nums) sum += num;
        boolean[] dp = new boolean[sum+1-m];
        dp[0] = true;

        for (int num : nums){
            for (int i = sum; i >= num; i--){
                dp[i] = dp[i] || dp[i-num];
                if (dp[i] && i > m && sum - i > m) return true;
            }
        }
        return false;
    }
}
