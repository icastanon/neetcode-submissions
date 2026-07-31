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
        ListNode slow = head, fast = Objects.nonNull(head) ? head.next : null;

        while(Objects.nonNull(slow) && Objects.nonNull(fast)){
            if(Objects.isNull(fast.next) || Objects.isNull(fast.next.next)){
                return false;
            }

            if(fast == slow || fast.next == slow || fast.next.next == slow){
                return true;
            }

            fast = fast.next.next;
            slow = slow.next;
        }

        return false;
        
    }
}
