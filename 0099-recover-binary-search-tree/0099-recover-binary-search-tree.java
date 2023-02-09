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
    public class Pair{
        TreeNode node;
		int state;
		Pair(TreeNode node, int state){
			this.node = node;
			this.state = state;
		}
    }
    public TreeNode getNextInorder(Stack<Pair> st){
		while(st.size() > 0){
			Pair top = st.peek();

			if(top.state == 1){
				//preorder
				top.state++;
				if(top.node.left != null){
					st.push(new Pair(top.node.left, 1));
				}
			}
			else if(top.state == 2){
				//inorder
				top.state++;
				if(top.node.right != null){
					st.push(new Pair(top.node.right, 1));
				}
				return top.node;
			}
			else{
				//postorder
				st.pop();
			}
		}
		return null;
	}
    public void recoverTree(TreeNode root) {
        //create a stack
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));
        
        //Initialise two node that will be swapped at last
        TreeNode a = null;
        TreeNode b = null;
        
        //initialise two pointers
        TreeNode prev = null;
        TreeNode curr = getNextInorder(st);
        
        while(curr != null){
            if(prev != null && prev.val > curr.val){
                if(a == null){
                    a = prev;
                    b = curr;
                }
                else{
                    b = curr;
                }
            }
            prev = curr;
            curr = getNextInorder(st);
        }
        
        //swap the values without changing the nodes
        
        int tval = a.val;
        a.val = b.val;
        b.val = tval;
    }
}