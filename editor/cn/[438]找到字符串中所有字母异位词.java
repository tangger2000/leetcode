
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for(char c: p.toCharArray())
            need.put(c, need.getOrDefault(c, 0)+1);

        int left=0, right=0, valid=0;
        List<Integer> res = new ArrayList<>();

        while(right < s.length()){
            char c = s.charAt(right);
            right++;
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c,0)+1);
                if(window.get(c).equals(need.get(c)))
                    valid++;
            }

            while (right-left >= p.length()){
                if(need.size() == valid)
                    res.add(left);
                char d = s.charAt(left);
                left++;

                if(need.containsKey(d)){
                    if(window.get(d).equals(need.get(d)))
                        valid--;
                    window.put(d, window.get(d)-1);
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
