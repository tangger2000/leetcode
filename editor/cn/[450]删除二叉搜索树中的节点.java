
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        if(root.val == key){
            // 左或右空
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;

            // 左右都不空，找到右子树的最左叶子节点
            TreeNode minNode = getMinNode(root.right);
            root.right = deleteNode(root.right, minNode.val);
            minNode.left = root.left;
            minNode.right = root.right;
            root = minNode;
        }
        else if(root.val > key)
            root.left = deleteNode(root.left, key);
        else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    TreeNode getMinNode(TreeNode root){
        while (root.left!=null) root = root.left;
        return root;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
