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
    
    public static void swap(ListNode p, ListNode q) {
        // ListNode temp = p;
        p.next = q.next;
        q.next = p;       
    }
    
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) 
            return head;
        
        ListNode newHead = head.next;
        ListNode p = head, q = p.next, r=null;
        // boolean flag=false;
        while(p!=null && q!=null) {
            swap(p, q);
            
            // Beacause of NullPointerException ;-;
            if(r!=null) r.next = q;
            if(p.next==null) break;
            
            q=p.next.next;
            r=p;
            
            p=p.next;
        }
        return newHead;
    }
}