
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i < inorder.length; i++)
            val2Idx.put(inorder[i], i);
        return construct(preorder, 0, preorder.length-1,
                        inorder, 0, inorder.length-1);
    }

    TreeNode construct(int[] preorder, int preStart, int preEnd,
                       int[] inorder, int inStart, int inEnd){
        if (preStart > preEnd) {
            return null;
        }
        int rootVal = preorder[preStart];

        int idx = val2Idx.get(rootVal);
        TreeNode root = new TreeNode(rootVal);

        int leftSize = idx - inStart;
        root.left = construct(preorder, preStart+1, preStart+leftSize,
                                inorder, inStart, idx-1);
        root.right = construct(preorder, preStart+leftSize+1, preEnd,
                                inorder, idx+1, inEnd);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
