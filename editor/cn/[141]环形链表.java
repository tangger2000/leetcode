
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        boolean res = false;

        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(fast==slow){
                res = true;
                break;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
