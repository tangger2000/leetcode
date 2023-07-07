
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
    // 递归反转链表实现(O(N)的空间)
//    public ListNode reverse(ListNode head){
//        if(head == null || head.next == null)
//            return head;
//
//        ListNode last = reverse(head.next);
//        head.next.next = head;
//        head.next = null;
//
//        return last;
//    }

    // 反转链表的空间O(1)实现
    public ListNode reverse(ListNode head){
        ListNode pre = null, cur = head, nxt = head;
        while (cur!=null){
            nxt = nxt.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    // 递归栈模拟双指针实现
    ListNode left;
    boolean traverse(ListNode right){
        if(right==null) return true;

        boolean res = traverse(right.next);
        res = res && (left.val == right.val);
        left = left.next;
        return res;
    }


    public boolean isPalindrome(ListNode head) {
//        // 递归反转链表实现
//        ListNode newHead = new ListNode(-1);
//        ListNode pp = newHead;
//        ListNode p = head;
//        while (p!=null){
//            ListNode node = new ListNode(p.val);
//            pp.next = node;
//            p = p.next;
//            pp = pp.next;
//        }
//        pp.next = null;
//        newHead = newHead.next;
//
//        newHead = reverse(newHead);
//
//         p = head;
//         pp = newHead;
//         while (p!=null){
//             if(p.val != pp.val)
//                 return false;
//             p = p.next;
//             pp = pp.next;
//         }
//        return true;

//        // 递归栈模拟双指针实现
//        left = head;
//        return traverse(head);

        // 优化栈递归模拟双指针实现
        ListNode slow, fast;
        slow = fast = head;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast!=null)
            slow = slow.next;

        ListNode left, right;
        left = head;
        right = reverse(slow);
        while (right!=null){
            if(left.val != right.val) return false;
            right = right.next;
            left = left.next;
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
