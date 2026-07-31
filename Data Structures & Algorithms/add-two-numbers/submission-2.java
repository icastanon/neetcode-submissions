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
        ListNode currentL1 = l1, currentL2 = l2, prev = null, sumHead = null; 
        int carry = 0;

        while(currentL1 != null || currentL2 != null){
            int l1Val = currentL1 == null ? 0 : currentL1.val;
            int l2Val = currentL2 == null ? 0 : currentL2.val;
            int sum = l1Val + l2Val + carry;
            
            if(sum >= 10){
                carry = 1;
                sum-=10;
            }else{
                carry = 0;
            }

            System.out.println(sum);

            ListNode sumNode = new ListNode(sum);

            if(prev != null){
                prev.next = sumNode;
            }else{
                sumHead = sumNode;
            }

            prev = sumNode;

            currentL1 = currentL1 != null ? currentL1.next : null;
            currentL2 = currentL2 != null ? currentL2.next : null;
        }

        if(carry > 0){
            prev.next = new ListNode(1);
        }

        return sumHead;
        
    }
}
