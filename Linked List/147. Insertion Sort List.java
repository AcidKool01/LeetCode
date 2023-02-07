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
    public ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }
        
        ListNode newHead = new ListNode(0);
        ListNode curr = head;
        ListNode prev = newHead;
        
        while(curr!=null) {
            prev = newHead;
            while(prev.next!=null && prev.next.val<curr.val) {
                prev=prev.next;
            }
            
            ListNode temp = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = temp;
        }
        
        return newHead.next;
    }
}