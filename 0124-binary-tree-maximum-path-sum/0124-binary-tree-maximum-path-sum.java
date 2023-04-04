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
    class Pair{
        int maxPathSum = 0;
        int sum =0;

        Pair(int sum, int maxPathSum){
            this.sum = sum;
            this.maxPathSum = maxPathSum;
        }
    }
    public Pair BestPathSum(TreeNode root){
        //base case
        if(root == null){
            return new Pair(0, Integer.MIN_VALUE);
        }

        Pair LeftPair = BestPathSum(root.left);
        Pair RightPair = BestPathSum(root.right);

        int bestLeftSum = Math.max(LeftPair.sum,0);
        int bestRightSum = Math.max(RightPair.sum, 0);
        int currMax = bestLeftSum + root.val + bestRightSum;
        int overallSum = Math.max(currMax, Math.max(LeftPair.maxPathSum, RightPair.maxPathSum));

        return new Pair(Math.max(bestLeftSum + root.val, bestRightSum + root.val),overallSum);
    }
    public int maxPathSum(TreeNode root) {
        return BestPathSum(root).maxPathSum;
    }
}