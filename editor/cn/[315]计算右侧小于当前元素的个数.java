
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<Integer> res = new ArrayList<>();
    int[] index;
    int[] count;
    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        index = new int[len];
        count = new int[len];

        for (int i=0; i<len; i++){
            index[i] = i;
        }
        MergeSort(nums, 0, len-1);
        for (int i=0; i<len; i++){
            res.add(count[i]);
        }
        return res;
    }

    void MergeSort(int[] nums, int start, int end){
        if(start < end){
            int mid = start + (end - start) / 2;
            MergeSort(nums, start, mid);
            MergeSort(nums, mid+1, end);
            merge(nums, start, mid, end);
        }
    }

    void merge(int[] nums, int start, int mid, int end){
        int partA = start;
        int partB = mid + 1;
        int cur = 0;
        int[] tmp = new int[end-start+1];
        int[] tmpIndex = new int[end-start+1];

        while (partA<=mid && partB<=end){
            if(nums[partA] > nums[partB]){
                count[index[partA]] += end-partB+1;
                tmp[cur] = nums[partA];
                tmpIndex[cur] = index[partA];
                partA ++;
            }else{
                tmp[cur] = nums[partB];
                tmpIndex[cur] = index[partB];
                partB ++;
            }
            cur ++;
        }

        while (partA<=mid){
            tmp[cur] = nums[partA];
            tmpIndex[cur] = index[partA];
            partA ++;
            cur++;
        }

        while (partB<=end){
            tmp[cur] = nums[partB];
            tmpIndex[cur] = index[partB];
            partB ++;
            cur++;
        }

        for (int i=0;i<end-start+1;i++){
            nums[i+start] = tmp[i];
            index[i+start] = tmpIndex[i];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
