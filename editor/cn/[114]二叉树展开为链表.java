
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

// 找左子树的最深右叶子
//class Solution {
//    public void flatten(TreeNode root) {
//        if(root == null)
//            return;
//
//        TreeNode rt = new TreeNode();
//        if(root.right==null && root.left==null)
//            return;
//        else if(root.left!=null){
//            rt = root.right;
//            TreeNode rightest = right(root.left);
//            rightest.right = rt;
//            root.right = root.left;
//            root.left = null;
//        }
//        flatten(root.right);
//    }
//
//    // 找最右边的节点
//    TreeNode right(TreeNode root){
//        if(root.right==null)
//            return root;
//        return right(root.right);
//    }
//}

//    // 后续遍历(先左后右)
//class Solution {
//    public void flatten(TreeNode root) {
//        if(root == null)
//            return;
//        flatten(root.left);
//        flatten(root.right);
//        TreeNode p = root.right;
//        root.right = root.left;
//        root.left = null;
//        // 将右子树放到左子树的最右叶子
//        while (root.right!=null) root = root.right;
//        root.right = p;
//    }
//}

// 后续遍历(先右后左)
// 左叶子（子树）并入即可，last始终指向符合题目要求的部分子树头节点
class Solution {
    TreeNode last = null;
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        flatten(root.right);
        flatten(root.left);

        root.right = last;
        root.left = null;
        last = root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
