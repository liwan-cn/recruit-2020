package bytedance0316.Test3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int m = sc.nextInt();
        while (m-- > 0){
            int n = sc.nextInt();
            int []arr = new int[n];
            for (int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            System.out.println(candy(arr));
        }
    }
    private static int candy(int[] ratings) {
        int[] candies = new int[ratings.length];

        Arrays.fill(candies, 1);
        int minIndex = -1, min = Integer.MAX_VALUE;
        for (int i = 0; i < ratings.length; i++){
            if (ratings[i] < min){
                min = ratings[i];
                minIndex = i;
            }
        }

        for (int i = minIndex+1; i < candies.length; i++){
            if (ratings[i] > ratings[i-1])
                candies[i] = candies[i-1] + 1;
        }
        if (minIndex >= 1 && ratings[0]  > ratings[ratings.length-1]){
            candies[0] = candies[candies.length-1] + 1;
        }

        for (int i = 1; i < minIndex; i++){
            if (ratings[i] > ratings[i-1])
                candies[i] = candies[i-1] + 1;

        }

        for (int i = minIndex-1; i >= 0; i--){
            if (ratings[i] > ratings[i+1])
                candies[i] = Math.max(candies[i], (candies[i + 1] + 1));
        }

        if (minIndex < ratings.length-1 && ratings[0]  < ratings[ratings.length-1]){
            candies[candies.length-1] = Math.max(candies[candies.length-1], candies[0] + 1);
        }

        for (int i = candies.length-2; i > minIndex; i--){
            if (ratings[i] > ratings[i+1])
                candies[i] = Math.max(candies[i], (candies[i + 1] + 1));
        }

        int sum = 0;
        for (int candy : candies){
            sum += candy;
            //System.out.println(candy);
        }

        return sum;
    }
}