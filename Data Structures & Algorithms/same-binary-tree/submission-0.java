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
    boolean ans=true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        dfs(p , q);

        return ans;
    }
    public void dfs(TreeNode roota , TreeNode rootb){
        if((roota==null&&rootb!=null)||(rootb==null&&roota!=null)) {
            ans=false;
            return;
            }
        else if(roota==null&&rootb==null){
            return;
        }
        else if(roota.val!=rootb.val) ans=false;
        else{
            dfs(roota.left , rootb.left);
            dfs(roota.right , rootb.right);
        }


    }
}
