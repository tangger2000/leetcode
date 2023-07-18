class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int[] res = new int[2];

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else if (target == nums[mid]) {
                right = mid - 1;
            }
        }
        if (left < 0 || left >= nums.length)
            res[0] = -1;
        else
            res[0] = nums[left] == target ? left : -1;

        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else if (target == nums[mid]) {
                left = mid + 1;
            }
        }
        if (right < 0 || right >= nums.length)
            res[1] = -1;
        else
            res[1] = nums[right] == target ? right : -1;

        return res;
    }
}
