
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeDuplicates(int[] nums) {
        int slow=2, fast=2;

        while (fast < nums.length){
            if(nums[slow - 2] != nums[fast]){
                nums[slow] = nums[fast];
                ++ slow;
            }
            ++ fast;
        }
        return slow;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
