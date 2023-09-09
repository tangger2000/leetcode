
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
    public List<TreeNode> generateTrees(int n) {
        return dfs(1,n);
    }

    List<TreeNode> dfs(int left, int right){
        List<TreeNode> cur = new ArrayList<>();
        if(left > right){
            cur.add(null);
            return cur;
        }

        for(int i=left; i<=right; i++){
            for(TreeNode leftNode: dfs(left, i-1)){
                for(TreeNode rightNode: dfs(i+1, right)){
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    cur.add(root);
                }
            }
        }
        return cur;
    }
}
