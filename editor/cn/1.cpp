#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
     vector<int> twoSum(vector<int>& nums, int target) {

        int i,j;
        for(i=0;i<nums.size()-1;i++)
        {
            for(j=i+1;j<nums.size();j++)
            {
                if(nums[i]+nums[j]==target)
                {
                    return {i,j};
                }
            }
        }
        return {i,j};
    }
};

int main()
{
    vector <int> in={2, 7, 11, 15};
    vector <int> out;
    int target = 9;
    Solution test;
    out = test.twoSum(in,target);
    for(int i=0;i<out.size();i++)
    {
        cout << out[i];
    }
}
