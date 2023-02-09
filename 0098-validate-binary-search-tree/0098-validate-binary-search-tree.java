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
    public boolean validate(TreeNode root, long lower, long upper){
        //if no node is present, BST is valid
        if(root == null){
            return true;
        }

        //If a node fails to satisfy the lower limit or upper limit, BST wont be valid.
        //that is, Node should lie in the limit of being less than lower and more than upper.
        if(root.val <= lower || root.val >= upper){
            return false;
        }

        boolean isLeftBst = validate(root.left, lower, root.val); //setting new upper limit
        boolean isRightBst = validate(root.right, root.val, upper);// setting new lower limit

        return isLeftBst && isRightBst;// return true if all the above conditions are satisfied.
    }
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}