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
    List<Integer> lista = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null) return lista;
        dfs(root);
        return lista;       
    }

    public void dfs(TreeNode root){
        if(root.left!=null) {
            dfs(root.left);
            //lista.add(root.left.val);
            }
        lista.add(root.val);
        if(root.right!=null) {
            dfs(root.right);
            //lista.add(root.right.val);
        }
        
    }
}