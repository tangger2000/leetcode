class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int res=0;
        for(int tmp:nums)
        {
            res ^= tmp;
        }
        return res;
    }
};
        
