
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
//    public List<List<Integer>> levelOrder(TreeNode root) {
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
//            res.add(tmp);
//        }
//
//        return res;
//    }

    // 前向遍历递归解法
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)
            return res;
        traverse(root, 0);
        return res;
    }
    void traverse(TreeNode root, int depth){
        if(root == null)
            return;

        if(res.size() <= depth)
            res.add(new LinkedList<>());

        res.get(depth).add(root.val);

        traverse(root.left, depth+1);
        traverse(root.right, depth+1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
