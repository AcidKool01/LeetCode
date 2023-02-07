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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        int sz=0;
        ListNode p = head;
        while(p!=null) {
            p=p.next;
            sz++;
        }
        
        int f = sz/k, r = sz%k;
        if(f==0) r = r-k;
        int j=0;
        p=head;
        ListNode q = null;
        
        while(p!=null) {
            res[j++] = p;
            for (int i=0; i<f-1; i++) {
                p=p.next;
            }
            
            if(r>0) {
                p=p.next;
                r--;
            }
            
            q = p.next;
            p.next = null;
            p = q;
        }
        
        return res;
    }
}