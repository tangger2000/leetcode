我太菜了，只想到了这样操作～～～～

class Solution {
public:
    string intToRoman(int num) {
        string res;
        while (num!=0) {
            if (num >= 1000) {
                res.append("M");
                num -= 1000;
            } else if (num >= 900) {
                res.append("CM");
                num -= 900;
            } else if (num >= 500) {
                res.append("D");
                num -= 500;
            } else if (num >= 400) {
                res.append("CD");
                num -= 400;
            } else if (num >= 100) {
                while (num >= 100) {
                    res.append("C");
                    num -= 100;
                }
            } else if (num >= 90) {
                res.append("XC");
                num -= 90;
            } else if (num >= 50) {
                res.append("L");
                num -= 50;
            } else if (num >= 40) {
                res.append("XL");
                num -= 40;
            } else if (num >= 10) {
                while (num >= 10) {
                    res.append("X");
                    num -= 10;
                }
            } else if (num >= 9) {
                res.append("IX");
                num -= 9;
            } else if (num >= 5) {
                res.append("V");
                num -= 5;
            } else if (num >= 4) {
                res.append("IV");
                num -= 4;
            } else if (num >= 1) {
                while (num >= 1) {
                    res.append("I");
                    num -= 1;
                }
            }
        }
        return res;
    }
};
