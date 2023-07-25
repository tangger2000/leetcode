
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
//    // 迭代解决
//    List<Integer> res = new ArrayList<>();
//    public List<Integer> largestValues(TreeNode root) {
//        if(root == null) return res;
//        Queue<TreeNode> q = new LinkedList<>();
//        q.offer(root);
//
//        while (!q.isEmpty()){
//            int sz = q.size();
//            int max = Integer.MIN_VALUE;
//            for(int i=0;i<sz;i++){
//                TreeNode cur = q.poll();
//                max = Math.max(max, cur.val);
//                if(cur.left!=null)
//                    q.offer(cur.left);
//                if(cur.right!=null)
//                    q.offer(cur.right);
//            }
//
//            res.add(max);
//        }
//
//        return res;
//    }
    // 递归解决
    List<Integer> res = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        traverse(root, 0);
        return res;
    }

    void traverse(TreeNode root, int depth){
        if(root == null)
            return;
        if(res.size() <= depth)
            res.add(Integer.MIN_VALUE);

        traverse(root.left, depth+1);
        traverse(root.right, depth+1);
        res.set(depth, Math.max(res.get(depth), root.val));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
