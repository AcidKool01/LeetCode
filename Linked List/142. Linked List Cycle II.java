// naive..

public class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<ListNode>();
        ListNode ptr = head;
        while(ptr!=null) {
            if(!set.contains(ptr)) {
                set.add(ptr);
                ptr=ptr.next;   
            } else {
                return ptr;
            }
        }
        return null;
    }
}

// floyd cycle

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow) {
                ListNode f = head;
                while(slow!=f) {
                    slow=slow.next;
                    f=f.next;
                }
                return f;
            }
        }
        return null;
    }
}