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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        
        ListNode pre1 = dummy1,pre2 = dummy2;
        ListNode temp = head;
        
        while(temp != null){
            if(temp.val < x){
                pre1.next = temp;
                pre1 = pre1.next;
            } else{
                pre2.next = temp;
                pre2 = pre2.next;
            }
            temp = temp.next;
        }
        
        pre2.next = null;
        pre1.next = dummy2.next;
        
        return dummy1.next;
    }
}