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
		Pair(TreeNode node,int state){
			this.node = node;
			this.state = state;
		}
	}

	public TreeNode getNextNormal(Stack<Pair> st){
		while(st.size()>0){
			Pair top = st.peek();
			if(top.state == 1){
				//pre
				top.state++;
				if(top.node.left != null) st.push(new Pair(top.node.left,1));
			}else if(top.state == 2){
				//in
				top.state++;
				if(top.node.right != null) st.push(new Pair(top.node.right,1));
				return top.node;
			}else{
				//post
				st.pop();
			}
		}
		return null;
	}
	public TreeNode getNextReverse(Stack<Pair> st){
		while(st.size()>0){
			Pair top = st.peek();
			if(top.state == 1){
				//pre
				top.state++;
				if(top.node.right != null) st.push(new Pair(top.node.right,1));
			}else if(top.state == 2){
				//in
				top.state++;
				if(top.node.left != null) st.push(new Pair(top.node.left,1));
				return top.node;
			}else{
				//post
				st.pop();
			}
		}
		return null;
	}
    public boolean findTarget(TreeNode root, int tar) {
        Stack<Pair> normal = new Stack<>();
		Stack<Pair> reverse =new Stack<>();

		normal.push(new Pair (root, 1));
		reverse.push(new Pair (root,1));

		TreeNode left = getNextNormal(normal); //will return the next inorder node in normal traversal
		TreeNode right = getNextReverse(reverse);// will return the next reverse inorder node in reverse traversal

		while(left.val < right.val){
			if(left.val + right.val == tar){
				return true;
				// left = getNextNormal(normal);
				// right = getNextReverse(reverse);
			}
			else if(left.val + right.val < tar){
				left = getNextNormal(normal);
			}
			else{
				right = getNextReverse(reverse);
			}
		}

		return false;
    }
}