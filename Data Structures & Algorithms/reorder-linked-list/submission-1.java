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
        ListNode fast = head, slow = head;
        int nodeCount = countNodes(head);
        int insertions = nodeCount/2; //How many insertions we need to make

        while(insertions != 0){
            ListNode prev = null;

            while(Objects.nonNull(fast.next)){
                //reach the end with the fast pointer
                prev = fast;
                fast = fast.next;
            }
            System.out.println("REACHED THE END " + fast.val);

            //insert it right next to the slow pointer
            prev.next = null;
            ListNode nextSlow = slow.next;
            slow.next = fast;
            fast.next = nextSlow;

            slow = nextSlow;

            insertions--;
        }
        
    }

    private int countNodes(ListNode head){
        int count = 0;
        while(Objects.nonNull(head)){
            count++;
            head = head.next;
        }

        return count;
    }
}
