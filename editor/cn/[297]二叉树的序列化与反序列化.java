
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    StringBuilder seria = new StringBuilder();
    String SEP = ",";
    String NULL = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
//        前序
//        preSerialize(root);
//        return seria.toString();
//        后序
//        postSerialize(root);
//        return seria.toString();
//        层序
        layerSerialize(root);
        return seria.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for(String s : data.split(SEP))
            nodes.addLast(s);
//        前序
//        return preDeserialize(nodes);
//        后序
//        return postDeserialize(nodes);
//        层序
        if(data.isEmpty()) return null;
        return layerDeserialize(nodes);
    }

    void preSerialize(TreeNode root) {
        if(root == null){
            seria.append(NULL).append(SEP);
            return;
        }

        seria.append(root.val).append(SEP);
        preSerialize(root.left);
        preSerialize(root.right);
    }

    public TreeNode preDeserialize(LinkedList<String> nodes) {
        if(nodes.isEmpty()) return null;

        String first = nodes.removeFirst();
        if(first.equals(NULL)) return null;

        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = preDeserialize(nodes);
        root.right = preDeserialize(nodes);
        return root;
    }

    void postSerialize(TreeNode root) {
        if(root == null){
            seria.append(NULL).append(SEP);
            return;
        }

        postSerialize(root.left);
        postSerialize(root.right);
        seria.append(root.val).append(SEP);
    }

    public TreeNode postDeserialize(LinkedList<String> nodes) {
        if(nodes.isEmpty()) return null;

        String last = nodes.removeLast();
        if(last.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(last));

        root.right = postDeserialize(nodes);
        root.left = postDeserialize(nodes);
        return root;
    }

    void layerSerialize(TreeNode root){
        if(root == null) return;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            int sz = q.size();
            for(int i=0;i<sz;i++){
                TreeNode cur = q.poll();
                if(cur == null){
                    seria.append(NULL).append(SEP);
                    continue;
                }

                seria.append(cur.val).append(SEP);
                q.offer(cur.left);
                q.offer(cur.right);
            }
        }
    }

    public TreeNode layerDeserialize(LinkedList<String> nodes){
        String rootVal = nodes.removeFirst();
        TreeNode root = new TreeNode(Integer.parseInt(rootVal));

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()){
            int sz = q.size();
            for(int i=0;i<sz;i++){
                TreeNode parent = q.poll();
                String left = nodes.removeFirst();
                String right = nodes.removeFirst();

                if(!left.equals(NULL)){
                    parent.left = new TreeNode(Integer.parseInt(left));
                    q.offer(parent.left);
                }
                if(!right.equals(NULL)){
                    parent.right = new TreeNode(Integer.parseInt(right));
                    q.offer(parent.right);
                }
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)
