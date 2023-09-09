
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 暴力递归过不了
//    public int coinChange(int[] coins, int amount) {
//        if(amount == 0) return 0;
//        if(amount < 0) return -1;
//
//        int res = Integer.MAX_VALUE;
//        for (int coin : coins){
//            int subProbe = coinChange(coins, amount-coin);
//            if(subProbe == -1) continue;
//            res = Math.min(res, subProbe+1);
//        }
//        return res == Integer.MAX_VALUE ? -1 : res;
//    }

    // memo
//    int[] memo;
//    public int coinChange(int[] coins, int amount) {
//        memo = new int[amount+1];
//        Arrays.fill(memo, -2);
//        return dp(coins, amount);
//    }
//    int dp(int[] coins, int amount){
//        if(amount == 0) return 0;
//        if(amount < 0) return -1;
//        if(memo[amount] != -2)
//            return memo[amount];
//
//        int res = Integer.MAX_VALUE;
//        for (int coin : coins){
//            int subProbe = dp(coins, amount-coin);
//            if(subProbe == -1) continue;
//            res = Math.min(res, subProbe+1);
//        }
//        memo[amount] = res == Integer.MAX_VALUE ? -1 : res;
//        return memo[amount];
//    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for (int i=0; i<dp.length; i++){
            for (int coin : coins){
                if(i - coin <0)
                    continue;
                dp[i] = Math.min(dp[i], 1+dp[i-coin]);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
