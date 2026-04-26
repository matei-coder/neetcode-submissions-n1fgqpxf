class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q);
    }

    public TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;        // fix: return null
        if (root.val == p.val || root.val == q.val) return root; // daca gasim p sau q, returnam direct

        TreeNode left  = dfs(root.left,  p, q);
        TreeNode right = dfs(root.right, p, q);

        if (left != null && right != null) return root; // p si q pe parti diferite
        return left != null ? left : right;             // altfel returnam ce am gasit
    }
}