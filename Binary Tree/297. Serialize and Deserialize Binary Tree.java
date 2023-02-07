// cleaner and better

public class Codec {
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                res.append("n ");
                continue;
            }
            res.append(node.val + " ");
            q.add(node.left);
            q.add(node.right);
        }
        return res.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == "") return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = q.poll();
            if (!values[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            if (!values[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
}


// not so clean solution

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String res= "";
        if(root==null) return "";
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        res = res + root.val + " ";
        
        while(!q.isEmpty()) {
            int n = q.size();
            for (int i=0; i<n; i++) {
                TreeNode currNode = q.poll();

                if(currNode.left!=null)  {
                    q.offer(currNode.left);
                    res = res + currNode.left.val + " ";
                }
                if(currNode.left == null) res = res + "#" + " ";
                if(currNode.right!=null) {
                    q.offer(currNode.right);
                    res = res + currNode.right.val + " ";
                }
                
                if(currNode.right == null) res = res + "#" + " ";
            }
        }
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="") return null;
        
        // System.out.println(data);
        
        String[] res = data.split(" ");
        // for(String p: res) System.out.println(p);
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        int x = Integer.parseInt(String.valueOf(res[0]));
        TreeNode root = new TreeNode(x);
        q.add(root);
        
        int i = 1;
        while(!q.isEmpty()) {
            int n = q.size();
            for (int j=0; j<n; j++) {
                TreeNode currNode = q.poll();
                if(i<res.length) {
                    if(res[i].equals("#")) currNode.left = null;
                    else {
                        x = Integer.parseInt(String.valueOf(res[i]));
                        TreeNode temp = new TreeNode(x);
                        currNode.left = temp;
                        q.offer(temp);
                    }
                    i++;
                } 
                if(i<res.length) {
                    if(res[i].equals("#")) currNode.right = null;
                    else {
                        x = Integer.parseInt(String.valueOf(res[i]));
                        TreeNode temp = new TreeNode(x);
                        currNode.right = temp;
                        q.offer(temp);
                    }
                    i++;
                }       
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));