
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();

        for(char c: t.toCharArray())
            need.put(c, need.getOrDefault(c, 0) + 1);

        int left=0, right=0, vaild=0;
        // 记录最小覆盖字串的起始位置核长度
        int start=0, len = Integer.MAX_VALUE;
        while (right < s.length()){
            char c = s.charAt(right);
            right++;

            // 更新数据
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if(window.get(c).equals(need.get(c)))
                    vaild++;
            }

            while(vaild == need.size()){
                 //更新数据
                if(right - left < len){
                    start = left;
                    len = right - left;
                }
                char d = s.charAt(left);
                left++;
                //更新数据
                if(need.containsKey(d)){
                    if(window.get(d).equals(need.get(d)))
                        vaild--;
                    window.put(d, window.get(d)-1);
                }
            }
        }
        return len == Integer.MAX_VALUE ?
                "" : s.substring(start, start + len);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
