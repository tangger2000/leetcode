/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length == 0) return;
        int slow = 0, fast = 0;
        while(fast < nums.length){
            if(nums[fast] != 0){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        while(slow < nums.length){
            nums[slow] = 0;
            slow++;
        }
    }
}
// @lc code=end

