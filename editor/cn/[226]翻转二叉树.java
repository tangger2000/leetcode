
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
    // 遍历解决
//    public TreeNode invertTree(TreeNode root) {
//        if(root == null)
//            return root;
//
//        traverse(root);
//        return root;
//    }
//
//    void traverse(TreeNode root){
//        if(root == null)
//            return;
//
//        TreeNode tmp = new TreeNode();
//
//        tmp = root.left;
//        root.left = root.right;
//        root.right = tmp;
//
//        traverse(root.left);
//        traverse(root.right);
//    }

    // 分解子问题解法
    public TreeNode invertTree(TreeNode root){
        if(root == null)
            return null;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
