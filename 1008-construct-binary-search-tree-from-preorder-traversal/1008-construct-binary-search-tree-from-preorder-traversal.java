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
    public int idx;
    public TreeNode construct(int[] pre, int low, int high){
        if(idx == pre.length){
            return null;
        }
        
        if(pre[idx] <= low || pre[idx] >= high){
            return null;
        }
        
        TreeNode me = new TreeNode(pre[idx]);
        idx++;
        
        me.left = construct(pre, low, me.val);
        me.right =construct(pre, me.val, high);
        
        return me;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = construct(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return root;
    }
}