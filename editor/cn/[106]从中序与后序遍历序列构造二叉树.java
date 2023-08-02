
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        for(int i=0; i<inorder.length; i++)
            val2Idx.put(inorder[i], i);
        return construct(inorder, 0, inorder.length-1,
                            postorder, 0, postorder.length-1);
    }
    TreeNode construct(int[] inorder, int inStart, int inEnd,
                       int[] postorder, int postStart, int postEnd){
        if(inStart > inEnd) return null;

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int idx = val2Idx.get(rootVal);
        // 左子树节点数目
        int leftSize = idx - inStart;
        root.left = construct(inorder, inStart, idx-1,
                                postorder, postStart, postStart+leftSize-1);
        root.right = construct(inorder, idx+1, inEnd,
                                postorder, postStart+leftSize, postEnd -1);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
