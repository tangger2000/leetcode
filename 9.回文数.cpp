string对象以及to_string 函数

class Solution {
public:
    bool isPalindrome(int x) {
        string str;
        string res;
        str = to_string(x);
        int len = str.length();
        while (len--)
        {
            res.push_back(str[len]);
        }
        return str == res;
    }
};


用个long long，负数特定不是回文。
class Solution {
public:
    bool isPalindrome(int x) {
        int start = x;
        int res=0;
        long long tmp=0;
        int add;
        if(x <= 0)
            res = 0;
        else
        {
            while (x!=0)
            {
                add = x % 10;
                x /= 10;
                tmp = tmp * 10 + add;
            }
        }
        if(start == tmp)
        {
            res = 1;
        }
        return res;
    }
};
