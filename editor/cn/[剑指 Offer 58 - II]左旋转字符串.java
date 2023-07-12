
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseLeftWords(String s, int n) {
        String left = s.substring(0, n);
        String right = s.substring(n);

        String res = right + left;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
