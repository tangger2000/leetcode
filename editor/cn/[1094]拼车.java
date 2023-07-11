
//leetcode submit region begin(Prohibit modification and deletion)
class Difference{
    int[] diff;

    public Difference(int[] nums){
        assert nums.length > 0;
        diff = new int[nums.length];
        diff[0] = nums[0];

        for (int i=1;i<nums.length;i++){
            diff[i] = nums[i] - nums[i-1];
        }
    }

    public void update(int i, int j, int val){
        diff[i]+=val;
        if(j+1 < diff.length)
            diff[j+1] -= val;
    }

    public int[] result(){
        int[] res = new int[diff.length];
        res[0] = diff[0];

        for (int i=1;i<res.length;i++){
            res[i] = res[i-1] + diff[i];
        }

        return res;
    }
}
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] nums = new int[1001];
        Difference df = new Difference(nums);

        for (int [] trip: trips){
            int val = trip[0];
            int i = trip[1];
            int j = trip[2]-1;
            df.update(i,j,val);
        }

        int[] res = df.result();

        for(int i=0; i<nums.length;i++){
            if(capacity < res[i])
                return false;
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
