
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
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode tail = head;
        ListNode pre = head;

        int idx = 1;
        while (pre.next!=null){
            pre = pre.next;
            idx += 1;
            if(idx > k){
                tail = tail.next;
            }
        }

        return tail;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
