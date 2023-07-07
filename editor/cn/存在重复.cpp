一组对撞指针（超时）
class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        int len = nums.size();
        if(nums.empty()||nums.size()==1) return {};
        if(nums.size()<3)
        {
            if(nums[0]==nums[1])
                return true;
            else
                return false;
        }
        for(int i=0;i<len-1;i++)
        {
            int j=i+1,k=len-1;
            while (j<=k)
            {
                if(nums[i]==nums[j]||nums[i]==nums[k])
                    return true;
                j++;
                k--;
            }
        }
        return false;
    }
};

排序＋相邻比对（通过）
class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        int len = nums.size();
        if(nums.empty()||nums.size()==1) return {};
        if(nums.size()<3)
        {
            return nums[0] == nums[1];
        }
        sort(nums.begin(),nums.end());
        for(int i = 0;i<len-1;i++)
        {
            if(nums[i]==nums[i+1])
                return true;
        }
        return false;
    }
};
