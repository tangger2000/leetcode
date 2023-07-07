// #include<bits/stdc++.h>
// using namespace std;

/*
 * @lc app=leetcode.cn id=704 lang=cpp
 *
 * [704] 二分查找
 */

// @lc code=start
// method 1 左闭右闭区间
class Solution {
public:
    int search(vector<int>& nums, int target) {
        int left=0;
        // size方法返回的是数组的个数，但标号减1
        int right=nums.size() - 1;
        // 因为是闭区间，所以两个l和r指向同一个是正确的，这是因为右闭导致的r指针有意义
        while(left <= right){
            int middle = (left+right) >> 1;
            if(nums[middle] < target){
                left = middle + 1;
            }else if(nums[middle] > target){
                right = middle - 1;
            }else{
                return middle;
            }
        }
        return -1;
    }
};

//method 2 左闭右开区间
// class Solution {
// public:
//     int search(vector<int>& nums, int target) {
//         int left=0;
//         int right=nums.size();
//         while(left < right){
//             int middle = (left+right) / 2;
//             if(nums[middle] < target){
//                 left = middle + 1;
//             }else if(nums[middle] > target){
//                 right = middle;
//             }else{
//                 return middle;
//             }
//         }
//         return -1;
//     }
// };
// @lc code=end

