
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 递归解法
    HashMap<Integer, Integer> map = new HashMap<>();
    public int numTrees(int n) {
        if(n==0 || n==1)
            return 1;
        if(map.containsKey(n))
            return map.get(n);

        int count =0;
        for(int i=1; i<=n; i++){
            int leftNum = numTrees(i-1);
            int rightNum = numTrees(n-i);
            count += leftNum * rightNum;
        }
        map.put(n, count);
        return count;
    }
    // dp
//    public int numTrees(int n) {
//        int[] dp = new int[n+1];
//        dp[0] = 1; dp[1] = 1;
//
//        for(int i=2; i<=n; i++){
//            for(int j=1; j<=i; j++){
//                dp[i] += dp[j-1] * dp[i-j];
//            }
//        }
//        return dp[n];
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
