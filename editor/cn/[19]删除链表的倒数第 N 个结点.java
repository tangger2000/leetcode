
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head;
        ListNode mid = head;
        ListNode tail = head;
        int idx = 1;
        while(pre.next!=null){
            pre = pre.next;
            idx += 1;
            if(idx > n){
                tail = mid;
                mid = mid.next;
            }
        }

        // 判断删除的是否是头结点
        if (mid == head) {
            return head.next;
        }

        tail.next = mid.next;
        mid.next = null;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
