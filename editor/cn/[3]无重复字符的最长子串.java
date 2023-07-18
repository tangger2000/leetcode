
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> window = new HashMap<>();

        int left=0, right=0;
        int res=0;
        while (right < s.length()){
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0)+1);
            right++;

            while (window.get(c) > 1){
                char d = s.charAt(left);
                left++;
                window.put(d, window.get(d)-1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
