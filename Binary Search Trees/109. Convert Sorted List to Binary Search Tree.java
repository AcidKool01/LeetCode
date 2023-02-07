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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private ListNode midNode (ListNode head, ListNode tail) {
        ListNode slow = head; ListNode fast = head;
        while(fast!=tail && fast.next!=tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    private TreeNode utilSolve (ListNode head, ListNode tail) {
        if(head==null || head==tail) return null;
        
        ListNode curr = midNode(head, tail);
        TreeNode root = new TreeNode(curr.val);
        root.left = utilSolve(head, curr);
        root.right = utilSolve(curr.next, tail);
        
        return root;
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        return utilSolve(head, null);
    }
}