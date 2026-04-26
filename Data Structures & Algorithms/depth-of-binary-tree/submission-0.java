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
    int count=0;
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        dfs(root , 1);
        return count;
    }


    public void dfs(TreeNode root , int c){
        if(root.left!= null ) dfs(root.left , c+1);
        if(root.right!= null) dfs(root.right , c+1);
        count  = Math.max(count , c);

    }
}
