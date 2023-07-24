
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructSubTree(nums, 0, nums.length-1);
    }

    private TreeNode constructSubTree(int[] nums, int left, int right){
        if(left > right)
            return null;

        int maxIdx = left;
        for (int i = left; i<=right; i++){
            if(nums[i] > nums[maxIdx])
                maxIdx = i;
        }

        TreeNode root = new TreeNode(nums[maxIdx]);
        root.left = constructSubTree(nums, left, maxIdx-1);
        root.right = constructSubTree(nums, maxIdx+1, right);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
