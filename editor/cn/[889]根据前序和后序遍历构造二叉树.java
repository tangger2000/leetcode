
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
    HashMap<Integer, Integer> val2Idx = new HashMap<>();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for(int i=0; i<postorder.length; i++)
            val2Idx.put(postorder[i], i);
        return construct(preorder, 0, preorder.length-1,
                postorder, 0, postorder.length-1);
    }
    TreeNode construct(int[] preorder, int preStart, int preEnd,
                       int[] postorder, int postStart, int postEnd){
        if(preStart > preEnd) return null;
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        int rootVal = preorder[preStart];
        int rootLeftVal = preorder[preStart+1];
        TreeNode root = new TreeNode(rootVal);
        int idx = val2Idx.get(rootLeftVal);
        // 左子树节点数目
        int leftSize = idx - postStart + 1;
        root.left = construct(preorder, preStart+1, preStart+leftSize,
                postorder, postStart, idx);
        root.right = construct(preorder, preStart+leftSize+1, preEnd,
                postorder, idx+1, postEnd -1);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
