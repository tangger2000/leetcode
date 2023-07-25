
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    // 迭代解法 N的空间
//    public Node connect(Node root) {
//          Queue<Node> q = new LinkedList<Node>();
//
//          if(root == null) return null;
//          q.offer(root);
//
//          while (!q.isEmpty()){
//              int sz = q.size();
//              Node pre = null;
//              for (int i=0; i < sz; i++){
//                  Node cur = q.poll();
//                  if(pre != null)
//                      pre.next = cur;
//                  pre = cur;
//
//                  if(cur.left!=null)
//                      q.offer(cur.left);
//                  if(cur.right!=null)
//                      q.offer(cur.right);
//              }
//          }
//          return root;
//    }

    // 递归解法
    public Node connect(Node root) {
        if(root == null) return null;
        if(root.left == null && root.right == null)
            return root;
        // 找到当前节点的右侧子节点
        Node next = getNode(root.next);
        if(root.left != null && root.right != null){
            root.left.next = root.right;
            root.right.next = next;
        }

        if(root.left != null && root.right == null)
            root.left.next = next;

        if(root.left == null && root.right != null)
            root.right.next = next;

        connect(root.right);
        connect(root.left);
        return root;
    }

    public Node getNode(Node root){
        if(root == null) return null;
        if(root.left != null) return root.left;
        if(root.right != null) return root.right;
        return getNode(root.next);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
