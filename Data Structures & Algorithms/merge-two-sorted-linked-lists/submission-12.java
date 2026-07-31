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
        ListNode n1 = list1;
        ListNode n2 = list2;
        ListNode prev = null;

        if(n1 == null){
            return n2;
        }else if(n2 == null){
            return n1;
        }

        while(n1 != null && n2 != null){
            if(n1.val > n2.val){
                ListNode nextList2 = n2.next;
                if(prev != null){
                    prev.next = n2;
                }
                n2.next = n1;
                prev = n2;
                n2 = nextList2;
            }else{
                prev = n1;
                n1 = n1.next;
            }
        }

        if(n2 != null){
            prev.next = n2;
        }

        return list1.val <= list2.val ? list1 : list2;
    }
}

// 1 1 2 4
//     1 1