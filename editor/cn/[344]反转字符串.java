
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void reverseString(char[] s) {
        int left=0, right=s.length-1;
        char tmp;

        while (left < right){
            tmp = s[right];
            s[right] = s[left];
            s[left] = tmp;

            left ++; right --;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
