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
        int size = countNodes(head);
        if(size > 1){
            ListNode otherHead = breakAndReverse(head);

            while(Objects.nonNull(head) && Objects.nonNull(otherHead)){
                ListNode nextHead = head.next, nextOtherHead = otherHead.next;

                head.next = otherHead;
                otherHead.next = nextHead;

                head = nextHead;
                otherHead = nextOtherHead;
            } 
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

    private ListNode breakAndReverse(ListNode head){
        int length = countNodes(head);
        int newTailIndex = length % 2 == 0 ? length/2 : (length/2) + 1;

        System.out.println("New head index " + newTailIndex);

        //break off second half of the list and reverse it
        int currentIndex = 0;
        ListNode prev = head;

        while(currentIndex != newTailIndex){
            prev = head;
            head = head.next;
            currentIndex++;
        }

        prev.next = null;

        System.out.println(head.val);

        return reverse(head);

    }

    private ListNode reverse(ListNode head){
        if(Objects.isNull(head)){
            return null;
        }

        ListNode prev = head, current = head.next; 
        prev.next = null;

        while(Objects.nonNull(current)){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
