/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/


public class Solution {
    
    //based on level order traversal
    public void connect(TreeLinkNode root) {

        TreeLinkNode head = null; //head of the next level
        TreeLinkNode prev = null; //the leading node on the next level
        TreeLinkNode cur = root;  //current node of current level

        while (cur != null) {
            
            while (cur != null) { //iterate on the current level
                //left child
                if (cur.left != null) {
                    if (prev != null) {
                        prev.next = cur.left;
                    } else {
                        head = cur.left;
                    }
                    prev = cur.left;
                }
                //right child
                if (cur.right != null) {
                    if (prev != null) {
                        prev.next = cur.right;
                    } else {
                        head = cur.right;
                    }
                    prev = cur.right;
                }
                //move to next node
                cur = cur.next;
            }
            
            //move to next level
            cur = head;
            head = null;
            prev = null;
        }
        
    }
}


// Same, Level Order Approach..But with using space

class Solution {
    List<List<Node>> level;
    private void levelOrder(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty()) {
            List<Node> currLevel = new ArrayList<Node>();
            int size = q.size();
            for(int i=0; i<size; i++) {
                Node currNode = q.poll();
                currLevel.add(currNode);
                
                if(currNode.left!=null) q.offer(currNode.left);
                if(currNode.right!=null) q.offer(currNode.right);
            }
            level.add(currLevel);
        }
    }

    public Node connect(Node root) {
        if(root==null) return root;
        level = new ArrayList<>();
        levelOrder(root);
        
        for(List<Node> currLevel: level) {
            for(int i=0; i<currLevel.size()-1; i++) {
                if(i!=currLevel.size()-1) currLevel.get(i).next = currLevel.get(i+1);
            }
            currLevel.get(currLevel.size()-1).next = null;
        }
            
        return root;
    }
};