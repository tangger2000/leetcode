暴力法：（超时）
class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        int temp,previous;
        int len = nums.size()-1;
        for(int i=0;i<k;i++)
        {
            previous = nums[len];
            for(int & num : nums)
            {
                temp = num;
                num = previous;
                previous = temp;
            }
        }
    }
};

环状替换：
class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        k = k%nums.size();
        int count = 0;
        for(int start = 0;count < nums.size();start++)
        {
            int current = start;
            int prev = nums[start];
            do{
                int next = (current + k)%nums.size();
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            }while (start!=current);
        }
    }
};

反转数组：
class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        k = k % nums.size();
        reverse(nums,0,nums.size()-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.size()-1);
    }
    void reverse(vector<int>& nums,int start,int end)
    {
        while (start<end)
        {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
};
