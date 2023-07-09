
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 0;

        while (fast < nums.length){
             if(fast > 0 && nums[fast] == nums[fast-1]){
                 fast++;
                 continue;
             }

             nums[slow] = nums[fast];
             fast ++;
             slow ++;
        }

        return slow;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
