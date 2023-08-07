
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
    int res=-1;
    int idx=0;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return -1;
        traverse(root, k);
        return res;
    }

    void traverse(TreeNode root, int k){
        if(root == null) return;
        traverse(root.left, k);
        idx += 1;
        if(idx == k){
            res = root.val;
            return;
        }
        traverse(root.right, k);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
