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
    public void reorderList(ListNode head) {
        int size = size(head);
        int lastNodeIndex = size - (size/2) - 1;
        ListNode n = head;

        for(int i = 0; i < lastNodeIndex; i++){
            n = n.next;
        }

        ListNode secondList = n.next;
        n.next = null;
        
        secondList = reverse(secondList);

        n = head;
        while(secondList != null){
            ListNode temp = secondList.next;
            ListNode next = n.next;
            secondList.next = n.next;
            n.next = secondList;
            n = next;
            secondList = temp;
        }
    }

    public int size(ListNode head){
        int count = 0;
        ListNode n = head;

        while(n != null){
            count++;
            n = n.next;
        }

        return count;
    }

    public ListNode reverse(ListNode n){
        ListNode prev = null;
        while(n != null){
            ListNode temp = n.next;
            n.next = prev;
            prev = n;
            n = temp;
        }

        return prev;
    }
}
