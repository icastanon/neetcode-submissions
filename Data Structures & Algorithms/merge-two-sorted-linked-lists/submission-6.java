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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode current = list1, inserting = list2, prev = null, head = list1;

        if(Objects.isNull(list1)){
            return list2;
        }else if(Objects.isNull(list2)){
            return list1;
        }else{
        while(Objects.nonNull(current) && Objects.nonNull(inserting)){
            if(current.val >= inserting.val){
                if(Objects.isNull(prev)){
                    head=inserting;
                }else{
                    prev.next=inserting;
                }
                ListNode insertingNext=inserting.next;
                inserting.next=current;
                prev = inserting;
                inserting=insertingNext;
            }else{
                prev=current;
                current=current.next;
            }
        }

        if(Objects.isNull(current)){
            prev.next=inserting;
        }

        return head;
        }
        
    }
}