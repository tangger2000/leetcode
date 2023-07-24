
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
    // 迭代解法
    //    public List<List<Integer>> levelOrderBottom(TreeNode root) {
//        List<List<Integer>> res = new ArrayList<>();
//
//        Queue<TreeNode> q = new LinkedList<>();
//        if(root==null)
//            return res;
//        q.offer(root);
//
//        while(!q.isEmpty()){
//            int sz = q.size();
//            List<Integer> tmp = new ArrayList<Integer>();
//            for(int i = 0; i<sz; i++){
//                TreeNode cur = q.poll();
//                tmp.add(cur.val);
//                if(cur.left != null)
//                    q.offer(cur.left);
//                if(cur.right != null)
//                    q.offer(cur.right);
//            }
//
//            res.add(0, tmp);
//        }
//
//        return res;
//    }
    // 后序遍历解法
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null)
            return res;
        traverse(root, 0);
        return res;
    }

    void traverse(TreeNode root, int depth) {
        if (root == null)
            return;

        // 每一个新层都new一个空列表
        if (depth >= res.size())
            res.add(0, new LinkedList<>());

        traverse(root.left, depth + 1);
        traverse(root.right, depth + 1);

        res.get(res.size() - depth - 1).add(root.val);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
