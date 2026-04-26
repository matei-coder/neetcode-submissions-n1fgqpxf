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
    boolean ans = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return ans;
    }
    public void dfs(TreeNode root){
        if(root==null) return;
        if(Math.abs(longestpath(root.left , 0)-longestpath(root.right, 0))>1) {
            ans = false;
            return;    
        }
        dfs(root.left);
        dfs(root.right);

    }
    public int longestpath(TreeNode root , int c){
        if(root==null) return c;
        return Math.max(longestpath(root.left , c+1) , longestpath(root.right , c+1));
    }
}
