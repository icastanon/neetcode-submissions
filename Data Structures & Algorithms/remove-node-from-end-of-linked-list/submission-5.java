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
        int size = size(head);
        n = size - n;
        dummy.next = head;

        for(int i = 0; i < n; i++){
            prev = node;
            node = node.next;
        }

        prev.next = node.next;
        node.next = null;

        return dummy.next;

    }

    public int size(ListNode n){
        int count = 0;
        while(n != null){
            count++;
            n = n.next;
        }

        return count;
    }
}
