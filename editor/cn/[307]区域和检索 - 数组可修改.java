
//leetcode submit region begin(Prohibit modification and deletion)
class NumArray {
    private int[] preSum;
    public NumArray(int[] nums) {
        preSum = new int[nums.length+1];
        preSum[0] = 0;

        for(int i=1; i<preSum.length;i++){
            preSum[i] = preSum[i-1] + nums[i-1];
        }
    }
    
    public void update(int index, int val) {
        int tmp = preSum[index+1] - preSum[index];
        tmp = val - tmp;
        for(; index < preSum.length-1; index++){
            preSum[index+1] += tmp;
        }
    }
    
    public int sumRange(int left, int right) {
        return preSum[right+1]-preSum[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
//leetcode submit region end(Prohibit modification and deletion)
