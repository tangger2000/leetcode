直接用<sstream>

class Solution {
public:
    int myAtoi(string str) {
        int d=0;
        istringstream is(str);
        is>>d;
        return d;
    }
};



没验证的一个

class Solution {
public:
    int myAtoi(string str) {
        bool flag = true; //正负（true：false)
        int len=str.length(); //str长度
        int add=0; //每次遍历得到的数字（要转化成int）
        long res=0;
        int cnt=0; //记录为空的个数
        int z=0;
        int f=0;

        //判断是否第一个非空格字符不是整数字符、字符串为空（预处理）
        if(str.empty()) {
            res = 0;
        }
        else if(!isdigit(str[0])&&str[0]!=' '&&str[0]!='-'&&str[0]!='+')
        {
            res = 0;
        }
        else
        {
            //处理字符串
            for(int i=0;i<len;i++)
            {
                if(str[i]=='-') //判断正负
                    flag = false;

                if(isdigit(str[i])) //判断当前是否为数字字符
                {
                    add = str[i] - 48;
                    if(res > INT_MAX/10 - 10 ||(res == INT_MAX && add > 7))  //如果大于最大值
                    {
                        res = INT_MAX;
                        break;
                    }
                    if(res < INT_MIN/10 + 10||(res == INT_MIN && add < -8))
                    {
                        res = INT_MIN;
                        break;
                    }
                    //必须先判断是否超出范围
                    res = flag?res*10 + add:res*10 - add;

                    if(!isdigit(str[i+1])) //下一个不是数字时,打断循环
                        break;

                }
                if(str[i]=='+') z = 1;
                if(str[i]=='-') f = 1;
                if(z==1&&f ==1)
                {
                    res = 0;
                    break;
                }

                if(isspace(str[i]))
                    cnt++;
            }
        }
        // 判断是否为全空字符串
        if(cnt == len)
        {
            res = 0;
        }
        return res;
    }
};
