
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
    int res = Integer.MAX_VALUE;
    int depth = 0;
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root){
        if(root == null)
            return;
        depth++;
        if(root.left==null && root.right==null)
            res = Math.min(res, depth);
        traverse(root.left);
        traverse(root.right);
        depth --;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
