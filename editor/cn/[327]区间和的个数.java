
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    long[] preSum;
    int lower;
    int upper;
    public int countRangeSum(int[] nums, int lower, int upper) {
        int len = nums.length;
        this.lower = lower;
        this.upper = upper;

        preSum = new long[len+1]; preSum[0] = 0;
//        构造初始前缀和数组
        for (int i=1;i<preSum.length;i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
//            System.out.println(preSum[i]);
        }

        return mergesort(preSum, 0, preSum.length-1);
    }

    int mergesort(long[] sums, int start, int end){
        if(start >= end) return 0;
        int mid = start + (end - start) / 2;
        int resLeft = mergesort(sums, start, mid);
        int resRight = mergesort(sums, mid+1, end);
        int res = resLeft + resRight;

        // 对已排序数组统计个数
        int i=start;
        int left = mid+1, right=mid+1;
        while (i <= mid) {
            while (left <= end && sums[left] - sums[i] < this.lower) left++;
            while (right <= end && sums[right] - sums[i] <= this.upper) right++;
            res += (right - left);
            i++;
        }

        // 归并
        long[] temp = new long[end-start+1];
        int tempIdx = 0;
        i = start; int j = mid+1;
        while (i <=mid && j <=end){
            if(sums[i] < sums[j]) temp[tempIdx++] = sums[i++];
            else temp[tempIdx++] = sums[j++];
        }
        while (i<=mid) temp[tempIdx++] = sums[i++];
        while (j<=end) temp[tempIdx++] = sums[j++];

        tempIdx = 0;
        while (tempIdx<temp.length) sums[start++] = temp[tempIdx++];
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
