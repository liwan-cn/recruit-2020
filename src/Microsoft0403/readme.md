# microsoft 04.03

## Test3 - 回文串消除

 一个数组, `1` 次可以消除 `1` 个数, 或者消除整个回文串  
 
 *`[1, 4, 3, 1, 5]` ==> 3次* 

1. ***消除 `arr[i to j]`, `dp[i, j] = min(dp[i, k] + dp[k+1, j]), k <= i to j-1`***
2. ***如果 `arr[i] == arr[j],  dp[i, j] = min(dp[i, j], dp[i+1, j-1])`***