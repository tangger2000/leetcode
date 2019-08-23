俺偷个懒～
class Solution {
public:
    bool isMatch(string s, string p) {
        regex r(p);
        return regex_match(s,r);
    }
};


