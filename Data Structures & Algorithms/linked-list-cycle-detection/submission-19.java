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
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;
        
        ListNode fast = head.next, slow = head;

        while(true){
            if(fast == slow)
                return true;
            
            slow = slow.next;
            fast = fast.next;

            if(fast == null || fast.next == null)
                return false;
            fast = fast.next;
        }
        
    }
}
