
// Itna ghatiya solution kaise soch leta hoon mai ;-;

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

class Solution {
    public Node connect(Node root) {
        Node curr = root;
        Queue<Node> q = new LinkedList();
        
        if(root==null) {
            return null;
        }
        
        curr.next = null;
        q.add(curr);
        
        while(!q.isEmpty()) {
            int size = q.size();
            List<Node> sed = new LinkedList();
            for (int i=0; i<size; i++) {
                Node temp = q.poll();
                sed.add(temp);
                if(temp.left!=null) {
                    q.add(temp.left);
                }
                if(temp.right!=null) {
                    q.add(temp.right);
                }
            }
            
            Iterator<Node> itr = null;
            itr = sed.listIterator();
            
            for (int j = 0; j<sed.size()-1; j++) {
                sed.get(j).next = sed.get(j+1);
            }
        }
        
        return root;
        
    }
}

// Matlab kya yaar..like seriously..wtf

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        if(root.left != null) root.left.next = root.right;
        if(root.right != null && root.next != null) root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
        return root;
    }

}