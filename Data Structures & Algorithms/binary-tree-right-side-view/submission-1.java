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
    List<Integer> ans = new ArrayList<>();
    int count=0;
    public List<Integer> rightSideView(TreeNode root) {
        if(root ==null) return ans;
        dfs(root , 0);
        return ans;
    }
    public void dfs(TreeNode root , int dist){
        
        if (ans.size() == dist) {  // ← nivel nou, nu a fost vizitat încă
            ans.add(root.val);
        }   
        if(root.right!=null) dfs(root.right , dist+1);
        if(root.left!=null) dfs(root.left , dist+1);
    }
}
