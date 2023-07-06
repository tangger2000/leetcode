
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1; ListNode p2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        while (p1!=null && p2!=null){
            if(p1.val > p2.val){
                p.next = p2;
                p2 = p2.next;
            }else{
                p.next = p1;
                p1 = p1.next;
            }
            p = p.next;
        }

        if(p1!=null){
            p.next = p1;
        }

        if(p2!=null){
            p.next = p2;
        }

        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
