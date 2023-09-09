
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 动规
//    public int lengthOfLIS(int[] nums) {
//        int[] dp = new int[nums.length];
//        Arrays.fill(dp, 1);
//
//        for (int i=0;i<nums.length;i++){
//            for(int j=0;j<i;j++){
//                if(nums[j] < nums[i])
//                    dp[i] = Math.max(dp[i], dp[j]+1);
//            }
//        }
//
//        int res=0;
//        for (int i=0; i< dp.length;i++){
//            res = Math.max(dp[i], res);
//        }
//        return res;
//    }

    // 二分法
    public int lengthOfLIS(int[] nums) {
        int[] top = new int[nums.length];
        int piles = 0;
        for (int i=0; i< nums.length; i++){
            int poker = nums[i];

            int left=0, right=piles;
            while (left<right){
                int mid = left + (right - left) / 2;
                if(top[mid] > poker)
                    right = mid;
                else if(top[mid] < poker)
                    left = mid+1;
                else
                    right = mid;
            }

            if(left == piles) piles++;
            top[left] = poker;
        }

        return piles;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
