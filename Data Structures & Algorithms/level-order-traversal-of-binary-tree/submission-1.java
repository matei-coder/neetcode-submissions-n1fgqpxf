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
    List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return ans;
        dfs(root , 0);
        return ans;
    }
    public void dfs(TreeNode root , int dist){
        if(ans.size()<=dist) ans.add(new ArrayList<Integer>());
        ans.get(dist).add(root.val);
        
        if(root.left!=null) dfs(root.left , dist+1);
        if(root.right!=null) dfs(root.right , dist+1);  

    }
}
