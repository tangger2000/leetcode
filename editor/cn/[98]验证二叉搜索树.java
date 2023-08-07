
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
//    我直接就是升序遍历
//    int pre; boolean flag = false; boolean res = true;
//    public boolean isValidBST(TreeNode root) {
//        traverse(root);
//        return res;
//    }
//    void traverse(TreeNode root){
//        if(root == null) return;
//        traverse(root.left);
//        if(!flag){
//            pre = root.val;
//            flag = true;
//        }
//        else{
//            if(root.val <= pre)
//                res = false;
//            else{
//                pre = root.val;
//            }
//        }
//        traverse(root.right);
//    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    boolean isValidBST(TreeNode root, TreeNode min, TreeNode max){
        if(root == null) return true;
        if(min !=null && root.val <= min.val) return false;
        if(max != null && root.val >= max.val) return false;
        return isValidBST(root.left, min, root)
                && isValidBST(root.right, root, max);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
