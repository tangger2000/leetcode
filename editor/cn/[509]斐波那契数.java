
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 暴力递归ac不了
//    public int fib(int n) {
//         if(n==1 || n==2)
//             return 1;
//         return fib(n-1) + fib(n-2);
//    }

    // memo递归解决
//    public int fib(int n){
//        int[] memo = new int[n+1];
//        System.out.println(memo[0]);
//        return  dp(memo, n);
//    }
//
//    int dp(int[] memo, int n){
//        if(n==0 || n==1) return n;
//        if(memo[n] !=0 ) return memo[n];
//        memo[n] = dp(memo, n-1) + dp(memo, n-2);
//        return memo[n];
//    }

    // dp table
    public int fib(int n){
        if(n == 0 || n==1) return n;
        int[] dp = new int[n+1];
        dp[0] =0; dp[1] = 1;
        for (int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
