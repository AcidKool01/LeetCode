//{ Driver Code Starts
import java.util.*;

class LNode
{
    int data;
    LNode next;
    LNode(int d) {
        data = d; 
        next = null;
    }
}

class TNode
{
    int data;
    TNode left, right;
    TNode(int x)
    {
        data=x;
        left=right=null;
    }
    
}


class ListToBST
{
    
  /* Function to print linked list */
   public static void preOrder(TNode root)
    {
        
        if(root==null)
            return;
            
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
	
	 
 
     /* Driver program to test above functions */
    public static void main(String args[])
    {
       
         
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 
		 while(t>0)
         {
			int n = sc.nextInt();
			LNode head = new LNode(sc.nextInt());
            LNode tail = head;
            for(int i=0; i<n-1; i++)
            {
                tail.next = new LNode(sc.nextInt());
                tail = tail.next;
            }
		
			Solution obj = new Solution();
			TNode root = obj.sortedListToBST(head);
			preOrder(root);
			
			System.out.println();
			
			t--;
			
         }
    }
}

// } Driver Code Ends


//User function Template for Java

/*Linked List Node
class LNode
{
    int data;
    LNode next;
    LNode(int d) {
        data = d; 
        next = null;
    }
}

//Tree Node
class TNode
{
    int data;
    TNode left, right;
    TNode(int x)
    {
        data=x;
        left=right=null;
    }
    
}*/

class Solution {
    
    private LNode findMid(LNode head, LNode tail) {
        LNode fast=head, slow=head;
        while(fast != tail && fast.next != tail) {
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    
    private TNode solve(LNode l, LNode h) {
        if(l == h) return null;
        
        LNode mid = findMid(l, h);
        TNode root = new TNode(mid.data);
        root.left = solve(l, mid);
        root.right = solve(mid.next, h);
        
        return root;
    }
    
    public TNode sortedListToBST(LNode head) {
        if(head == null) return null;
        if(head.next == null) return new TNode(head.data);
        
        TNode root = solve(head, null);
        return root;
    }
}