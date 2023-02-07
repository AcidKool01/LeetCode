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
    
    private int countTheNode(ListNode head) {
        ListNode p = head;
        int count=1;
        while(p!=null) { count++; p=p.next; }
        return count;
    }
    
    public int pairSum(ListNode head) {
        int count = countTheNode(head);
        int res = 0;
        Stack<ListNode> st = new Stack<ListNode>();
        ListNode p = head;
        count = count/2;
        
        while(count-- > 0) {
            st.push(p);
            p=p.next;
        }
        
        while(p!=null) {
            ListNode temp = st.pop();
            res = Math.max(p.val + temp.val, res);
            p=p.next;
        }
        
        return res;
    }
}