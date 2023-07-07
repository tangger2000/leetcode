// 法1：map对象

class Solution {
public:
    int romanToInt(string s) {
        int len = s.length();
        map <char,int> a = {{'I',1}, {'V',5}, {'X',10}, {'L',50}, {'C',100}, {'D',500}, {'M',1000}};
        int res=0;
        for(int i=0;i<len;i++)
        {
            if(a[s[i]]<a[s[i+1]])
            {
                res -= a[s[i]];
            }
            else
                res += a[s[i]];
        }
        return res;
    }
};



//法2：很适合cv的写法，哈哈哈～

class Solution {
public:
    int romanToInt(string s) {
        int len = s.length();
        int res = 0;
        for(int i = len;i >= 0;i--)
        {
            if(s[i]=='I') res += 1;

            if(s[i]=='V')
            {
                if(s[i-1]=='I')
                {
                    res += 4;
                    i--;
                }
                else
                    res += 5;
            }

            if(s[i]=='X')
            {
                if(s[i-1]=='I')
                {
                    res += 9;
                    i--;
                }
                else
                    res += 10;
            }

            if(s[i]=='L')
            {
                if(s[i-1]=='X')
                {
                    res += 40;
                    i--;
                }
                else
                    res += 50;
            }

            if(s[i]=='C')
            {
                if(s[i-1]=='X')
                {
                    res += 90;
                    i--;
                }
                else
                    res += 100;
            }

            if(s[i]=='D')
            {
                if(s[i-1]=='C')
                {
                    res += 400;
                    i--;
                }
                else
                    res += 500;
            }

            if(s[i]=='M')
            {
                if(s[i-1]=='C')
                {
                    res += 900;
                    i--;
                }
                else
                    res += 1000;
            }
        }
        return res;
    }
};
