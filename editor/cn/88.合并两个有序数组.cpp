/*
 * @lc app=leetcode.cn id=88 lang=cpp
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        vector<int>& nums = nums1;
        int i = m - 1, j = n - 1, k = m + n - 1;

        while(i >=0 && j>=0){
            if(nums1[i] > nums2[j]){
                nums[k] = nums1[i];
                k--;
                i--;
            }
            else{
                nums[k] = nums2[j];
                k--;
                j--;
            }
        }
        
        while(j >= 0){
            nums[k] = nums2[j];
            k--;
            j--;
        }
    }
};
// @lc code=end

