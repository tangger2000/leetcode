
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int left=0, right=nums.length-1;
        int[] res = new int[2];

        while (left < right){
            int sum = nums[left] + nums[right];
            if(sum > target)
                right --;
            else if(sum < target)
                left ++;
            else {
                res[0] = nums[left];
                res[1] = nums[right];
                break;
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
