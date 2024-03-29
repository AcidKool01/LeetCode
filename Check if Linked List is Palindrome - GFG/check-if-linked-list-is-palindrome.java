//{ Driver Code Starts
import java.util.*;

class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}

class Is_LinkedList_Palindrom
{
	 Node head;  
	 Node tail;
	
	/* Function to print linked list */
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
	
 
    /* Inserts a new Node at front of the list. */
    public void addToTheLast(Node node) 
	{

		if (head == null) 
		{
			head = node;
			tail = node;
		} else 
		{
		    tail.next = node;
		    tail = node;
		}
    }
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		 
		while(t>0)
        {
			int n = sc.nextInt();
			//int k = sc.nextInt();
			Is_LinkedList_Palindrom llist = new Is_LinkedList_Palindrom();
			//int n=Integer.parseInt(br.readLine());
			int a1=sc.nextInt();
			Node head= new Node(a1);
            Node tail = head;
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
			    tail.next = new Node(a);
			    tail = tail.next;
			}
			
			Solution g = new Solution();
			if(g.isPalindrome(head) == true)
			    System.out.println(1);
		    else
			    System.out.println(0);
			t--;
		}
		
	}
}




// } Driver Code Ends


/* Structure of class Node is
class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}*/

class Solution {
    private Node reverse(Node head) {
        Node ptr1 = head, ptr2 = null, ptr3 = null;
        while(ptr1 != null) {
            ptr3 = ptr2;
            ptr2 = ptr1;
            ptr1 = ptr1.next;
            ptr2.next = ptr3;
        }

        return ptr2;
    }

    private Node findMidNode(Node head) {
        Node ptr1 = head, ptr2 = head;
        while(ptr1.next != null && ptr1.next.next != null) {
            ptr1 = ptr1.next.next;
            ptr2 = ptr2.next;
        }
        return ptr2;
    }

    public boolean isPalindrome(Node head) {
        if(head.next == null) return true;
        Node mid = findMidNode(head);
        Node ptr = reverse(mid);

        while(ptr!=null && head!=null) {
            if(ptr.data != head.data) return false;
            ptr = ptr.next;
            head = head.next;
        }

        return true;
    }  
}

