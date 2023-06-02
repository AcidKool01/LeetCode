//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java
import java.io.*;
import java.util.*;
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
class insertion
{
    Node head;  
    Node tail;
	public void addToTheLast(Node node) 
	{
	  if (head == null) 
	  {
	   head = node;
	   tail = node;
	  } 
	  else 
	  {
	   tail.next = node;
	   tail = node;
	  }
	}
      void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	/* Drier program to test above functions */
	public static void main(String args[])throws IOException
    {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Scanner sc = new Scanner(System.in);
		 int t=Integer.parseInt(br.readLine());
		 while(t>0)
         {
            String S[] = br.readLine().split(" ");
			int N = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            int n = Integer.parseInt(S[2]);
		
		    String S1[] = br.readLine().split(" ");
			insertion llist = new insertion(); 
			int a1=Integer.parseInt(S1[0]);
			Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < N; i++) 
			{
				int a = Integer.parseInt(S1[i]);
				llist.addToTheLast(new Node(a));
			}
			
        Solution ob = new Solution();
		Node newhead=ob.reverseBetween(llist.head, m, n);
		llist.printList(newhead);
		
        t--;		
        }
    }}
// } Driver Code Ends


//User function Template for Java

/*
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    */
class Solution {
    
    private static Node reverseList(Node m, Node n, Node prevM) {
        Node temp = m;
        Node p=m.next, q=m, r=m;
        while(p != n) {
            // System.out.println(p.data + ", " + q.data + ", " + r.data);
            r=q;
            q=p;
            p=p.next;
            q.next = r;
        } 
        
        m.next = p;
        // q.next = prevM;
        
        return q;
    }
    
    public static Node reverseBetween(Node head, int m, int n) {
        int count=1;
        Node n1= null, n2=null, curr=head;
        Node prev = null, prevM = null;
        while(curr != null) {
            if(count == m) { prevM = prev; n1 = curr; }
            if(count == n) n2 = curr;
            prev = curr;
            curr=curr.next;
            count++;
        }
        
        Node x = reverseList(n1, n2.next, prevM);
        if(m == 1) return x;
        else prevM.next = x;
        return head;
    }
}