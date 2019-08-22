超时算法：（我太他妈的菜了）
class Solution {
public:
    string convert(string s, int numRows) {
        string res;
        int leng = s.length();
        int add = 0;  //行间距
        int step = 2*numRows-2; //层级间距（N的每个|为层）
        int index; //字符串s的下标
        for(int i=0;i<numRows;i++)
        {
            index = i;
            add = i * 2;
            while (index < leng) //当每行遍历完了，进行下一行的遍历
            {
                res += s[index];
                add = step -add;
                index += (i==0||i==numRows-1)?step:add; //判断是否为第一行和最后一行（第一行和最后一行的index为step间隔)
            }
        }
        return res;
    }
};


别人的思路：
class Solution {
public:
    string convert(string s, int numRows) {
        if(numRows==1) return s;

        vector <string> rows(min(numRows,int(s.length())));
        int curRows = 0;
        bool goingDown =false;

        for(auto c:s)
        {
            rows[curRows] += c;
            if(curRows==0||curRows==numRows-1)
            {
                goingDown = !goingDown;
            }
            curRows += goingDown?1:-1;
        }

        string res;
        for(string row:rows)
        {
            res += row;
        }
        return res;
    }
};
