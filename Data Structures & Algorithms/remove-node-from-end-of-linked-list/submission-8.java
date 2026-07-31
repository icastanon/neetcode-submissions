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
        ListNode node = head, dummy = new ListNode(), prev = dummy;
        dummy.next = head;

        for(int i = 1; i < n; i++){
            node = node.next;
        }

        while(node.next != null){
            prev = head;
            head = head.next;
            node = node.next;
        }

        prev.next = head.next;
        head.next = null;

        return dummy.next;

    }
}
