
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
    int curSum = 0;
    public TreeNode bstToGst(TreeNode root) {
        traverse(root);
        return root;
    }

    void traverse(TreeNode root){
        if(root == null) return;

        traverse(root.right);
        root.val += curSum;
        curSum = root.val;
//        System.out.println(root.val);
        traverse(root.left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
