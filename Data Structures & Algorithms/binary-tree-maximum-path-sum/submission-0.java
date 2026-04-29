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
    int max=-1001;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
    public int dfs(TreeNode root){
        if(root==null)return 0;
        int sumapedreapta = Math.max(dfs(root.right), 0 );
        int sumapestanga  = Math.max(dfs(root.left) , 0 );

        max = Math.max(max , sumapestanga+sumapedreapta+root.val);
        return Math.max(sumapestanga , sumapedreapta)+root.val;
    }
}
