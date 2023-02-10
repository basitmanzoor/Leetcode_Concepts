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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null){
            return null;
        }
        
        //Case 1: if the root is less that lower range, that means root and its left subtree wont be included in the trimmed tree
        if(root.val < low){
            return trimBST(root.right, low, high);
        }
        //case 2: if the root is greater than the higher range, it means root and its right subtree wont be incuded int he trimmed tree
        else if(root.val > high){
            return trimBST(root.left, low, high);
        }
        //calling left and right subtrees;
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        
        //case 3: when the root lies between the range 
        return root;
        
    }
}