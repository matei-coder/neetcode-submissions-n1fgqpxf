class Solution {
    boolean ans = true;

    public boolean isValidBST(TreeNode root) {
        ans = true;
        dfs(root, Long.MAX_VALUE, Long.MIN_VALUE);
        return ans;
    }

    public void dfs(TreeNode root, long max, long min) {
        if (root == null) return;
        if (root.val >= max) ans = false;
        if (root.val <= min) ans = false;
        dfs(root.left, root.val, min);   // ← stânga: max devine root.val
        dfs(root.right, max, root.val);  // ← dreapta: min devine root.val
    }
}