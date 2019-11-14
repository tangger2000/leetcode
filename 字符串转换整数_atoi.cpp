    class Solution {
    private:
        int index=0,sign=1,len;
        long long sum =0;
    public:
        int myAtoi(string str) {
            if(str.empty())
                return 0;
            len = str.length();

            while (index<len && isspace(str[index]))
                index++;

            if(index<len && (str.at(index) == '+'|| str.at(index) == '-'))
                sign = 1 - 2*((str.at(index++)=='-')?1:0);

            while (index<len && isdigit(str[index]))
            {
                if(sum > INT32_MAX/10 || (sum == INT32_MAX/10 && str.at(index)-'0' > 7)) {
                    if (sign == 1)
                        return INT32_MAX;
                    else
                        return INT32_MIN;
                }

                sum = sum*10 + str.at(index++) - '0';
            }
            return sign*sum;
        }
    };
