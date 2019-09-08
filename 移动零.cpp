法一：暴力比较移动

class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        for(int i=0;i<nums.size();i++)
        {
            if(nums[i]==0)
                continue;
            
            int j=i;
            while (j>0&&nums[j-1]==0&&nums[j]!=0)
            {
                nums[j-1]=nums[j];
                nums[j]=0;
                j--;
            }
        }
    }
};
