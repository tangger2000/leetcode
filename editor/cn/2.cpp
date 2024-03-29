/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode *head = new ListNode(0);
        ListNode *p = head;
        int sum =0;
        int extra =0;
        while (l1 || l2 || extra)
        {
            sum = (l1?l1->val:0) + (l2?l2->val:0) + extra;
            extra = sum /10;
            l1 = l1?l1->next:l1;
            l2 = l2?l2->next:l2;
            p->next = new ListNode(sum % 10);
            p = p->next;
        }
        return head->next;
    }
};
