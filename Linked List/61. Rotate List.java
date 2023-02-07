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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null) 
            return head;
        if(k==0)
            return head;
        
        ListNode p = head;
        int len = 1;
        while(p.next!=null) {
            p=p.next;
            len++;
        }
        p.next = head;
        
        k = k%len;
        int r = len-k-1;
        p=head;
        
        while(r!=0) {
            p = p.next;
            r--;
        }
        
        head=p.next;
        p.next=null;
          
        return head;
    }
}