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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(), n = dummy;
        

        while(l1 != null || l2 != null){
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;

            int sum = l1Val + l2Val + carry;
            
            if(sum >= 10){
                sum = sum - 10;
                carry = 1;
            }else{
                carry = 0;
            }

            n.next = new ListNode(sum);
            n = n.next;

            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;

        }

        if(carry > 0){
            n.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
