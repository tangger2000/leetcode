双指针法

class Solution {
public:
    int maxArea(vector<int>& height) {
        int maxNum=0;
        int i=0,j=height.size()-1;
        while (i < j)
        {
            maxNum = max(maxNum , min(height[i],height[j]) * (j-i));
            if(height[i] < height[j]) i++;
            else j--;
        }
        return maxNum;
    }
};


暴力枚举。。。（咕咕咕～）
