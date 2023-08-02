
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
    HashMap<String, Integer> subTree = new HashMap<>();
    LinkedList<TreeNode> res = new LinkedList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return res;
    }

    String serialize(TreeNode root){
        if(root == null)
            return "#";

        String left = serialize(root.left);
        String right = serialize(root.right);

        String curr = left + "," + right + "," + root.val;
        int freq = subTree.getOrDefault(curr, 0);

        if(freq == 1){
            res.add(0, root);
        }

        subTree.put(curr, freq+1);
        return curr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
