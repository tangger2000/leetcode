
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
    // 遍历解法
//    int res = 0;
//    int depth = 0;
//    public int maxDepth(TreeNode root) {
//        traverse(root);
//        return res;
//    }
//    private void traverse(TreeNode root){
//        if(root == null)
//            return;
//        depth++;
//        res = Math.max(res, depth);
//        traverse(root.left);
//        traverse(root.right);
//        depth--;
//    }

    // 分解子问题
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        int res = Math.max(leftDepth, rightDepth) + 1;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
