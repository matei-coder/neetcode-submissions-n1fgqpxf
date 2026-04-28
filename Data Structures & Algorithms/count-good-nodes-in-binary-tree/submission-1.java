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
    int nrofgoods = 0;
    List<Integer> lista = new ArrayList<>();
    public int goodNodes(TreeNode root) {
        dfs(root , lista);
        return nrofgoods;
    }
    public void dfs(TreeNode root , List<Integer> lista){
        if(biggest(root , lista)) nrofgoods++;
        lista.add(root.val);
        if(root.right!=null) dfs(root.right , lista);
        if(root.left!=null) dfs(root.left , lista);
        lista.remove((Integer)root.val);
    }

    public boolean biggest(TreeNode root , List<Integer> lista){
        boolean ans = true;
        for(int x:lista){
            if(x>root.val) ans=false;
        }
        return ans;
    }
}
