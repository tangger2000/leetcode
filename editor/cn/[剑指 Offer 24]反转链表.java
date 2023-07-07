
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        // 递归
//        if(head == null || head.next == null) return head;
//
//        ListNode last = reverseList(head.next);
//        head.next.next = head;
//        head.next = null;
//
//        return last;
        // 迭代
        ListNode pre, cur, nxt;
        pre = null; cur = head; nxt = head;
        while (cur != null){
            nxt = nxt.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
