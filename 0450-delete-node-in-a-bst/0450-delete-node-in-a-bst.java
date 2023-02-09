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
    public int getMin(TreeNode root){
		if(root.left == null) return root.val;
		return getMin(root.left);
	}
    public TreeNode deleteNode(TreeNode root, int val) {
        if(root == null){ //if no node is present in the BST
			return null;
		}
		if(root.val == val){
		    if(root.left == null && root.right == null){ //This is Leaf node condition
			    return null;
		    }
		    else if(root.left == null && root.right != null)//root is having only rigth  subtree
		    {
			    return root.right;
	        }
		    else if(root.left != null && root.right == null){//root is having only left child
			    return root.left;
		    }
		    else{ //if both child are present
			    //Step 1: we will get min from right subtree
			    int minVal = getMin(root.right);
			    //Step 2: override
			    root.val = minVal;
			    //step 3: delete min val from my right subtree
			    root.right = deleteNode(root.right, minVal);
		   }
	    }
		else if(root.val < val){
			root.right = deleteNode(root.right, val);
		}
		else{
			root.left = deleteNode(root.left, val);
		}
		return root;
    }
}