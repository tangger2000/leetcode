对撞指针+剪枝
class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        int res=0;
        int len = nums.size();
        int tarSum = INT_MAX;

        sort(nums.begin(),nums.end());
        if(nums.empty()||nums.size()<3) return 0;

        for(int i = 0;i<len;i++)
        {
            if(i>0&&nums[i]==nums[i-1]) continue; //剪枝

            int j = i+1,k=len-1;
            while (j<k)
            {
                int sum = nums[i] + nums[j] + nums[k];

                if(sum > target) k--;
                else if(sum < target) j++;
                else if(sum == target) return target;

                if(abs(sum-target) < tarSum)
                {
                    tarSum = abs(sum-target);
                    res = sum;
                }
            }
        }
        return res;
    }
};
