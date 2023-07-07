三指针：排序+对撞指针+剪枝优化

class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        int len = nums.size();
        int s;
        vector<vector<int>> res;

        sort(nums.begin(),nums.end());
        if(nums.empty()||nums.front()>0||nums.back()<0)
            return {};

        for(int i=0;i<len;i++)
        {
            if(nums[i]>0) break;  //num[i]>0时退出循环
            if(i>0&&nums[i]==nums[i-1]) continue; //去除重复
            int j=i+1;
            int k = len - 1;
            while(j<k)
            {
               s = nums[i] + nums[j] +nums[k];
               if(s == 0)
               {
                   if(j==i+1||k == len -1) {
                       res.push_back(vector<int>{nums[i], nums[j], nums[k]});
                       j++;
                       k--;
                   }
                   else if(nums[j]==nums[j-1])
                       j++;
                   else if(nums[k]==nums[k+1])
                       k--;
                   else
                   {
                       res.push_back(vector<int>{nums[i],nums[j],nums[k]});
                       j++;
                       k--;
                   }
               }
               else if (s > 0)
                   k--;
               else
                   j++;
            }
        }
        return res;
    }
};
