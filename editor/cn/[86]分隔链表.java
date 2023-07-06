
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
    public ListNode partition(ListNode head, int x) {
        ListNode list1 = new ListNode(-1); ListNode list2 = new ListNode(-1);
        ListNode p1 = list1; ListNode p2 = list2;
        ListNode p = head;

        while (p!=null){
            if(p.val < x){
                p1.next = p;
                p1 = p1.next;
            }else{
                p2.next = p;
                p2 = p2.next;
            }
            ListNode tmp = p.next;
            p.next = null;
            p = tmp;
        }
        p1.next = list2.next;
        return list1.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
