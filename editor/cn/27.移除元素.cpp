/*
 * @lc app=leetcode.cn id=27 lang=cpp
 *
 * [27] 移除元素
 */

// @lc code=start
// 单循环双指针
class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        if(nums.size()==0)
            return 0;
        int slow = 0;
        for(int fast=0; fast <= nums.size()-1; fast++){
            if(val != nums[fast]){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
};
// @lc code=end

