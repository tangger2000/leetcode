
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
    int res=0;
    int depth=0;
    int maxDepth=0;
    public int findBottomLeftValue(TreeNode root) {
        traverse(root);
        return res;
    }
    private void traverse(TreeNode root){
        if(root==null)
            return;
        depth++;
        if((root.left==null && root.right==null) && depth > maxDepth){
            res = root.val;
            maxDepth = depth;
        }
        traverse(root.left);
        traverse(root.right);
        depth--;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
