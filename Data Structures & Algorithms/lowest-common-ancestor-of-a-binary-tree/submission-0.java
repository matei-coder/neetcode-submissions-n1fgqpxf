/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> lista1 = new ArrayList<>();
        List<TreeNode> lista2 = new ArrayList<>();
        dfs(root , p.val , lista1);
        dfs(root , q.val , lista2);
        TreeNode ans = null;
        for(int i=0;i<Math.min(lista1.size() , lista2.size());i++){
            if(lista1.get(i) == lista2.get(i)) ans = lista1.get(i);
            else break;
        }
        return ans;


    }

    public boolean dfs(TreeNode curr , int target , List<TreeNode> lista){
        if(curr == null) return false;
        lista.add(curr);
        if(curr.val == target) return true;

        if (dfs(curr.left, target, lista) || dfs(curr.right, target, lista)) {
            return true;
        }

        lista.remove(lista.size()-1);

        return false;
    }
}