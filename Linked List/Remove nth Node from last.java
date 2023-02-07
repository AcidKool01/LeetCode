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
        ListNode p = head, q=head;
        int k = n;
        while(k!=0) {
            p = p.next;
            k--;
        }
        
        if(p==null) {
            return q.next;
        }
        
        while(p.next!=null) {
            p=p.next;
            q=q.next;
        }
        
        q.next = q.next.next;
        
        return head;
    }
}