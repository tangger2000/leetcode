
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int sumOfPower(int[] nums) {
        long Mod = 1000000007, minSum=0, powerSum=0;
        // 排序
        Arrays.sort(nums);

        for(int num : nums){
            powerSum = (powerSum + (minSum + num)%Mod * num %Mod *num%Mod) % Mod;
            minSum = (minSum * 2 + num) % Mod;
        }
        return (int)powerSum;
    }
}