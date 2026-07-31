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
        ListNode left = head;

        int i = 0;
        ListNode right = head;
        while(i < n && Objects.nonNull(right)){
            right = right.next;
            i++;
        }

        // System.out.println(right.val);

        if(Objects.isNull(right)){
            return head.next;
        }

        while(Objects.nonNull(right.next)){
            right = right.next;
            left = left.next;
        }

        left.next = left.next.next;

        return head;
    }
}
