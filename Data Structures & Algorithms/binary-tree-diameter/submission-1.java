class Solution {
    int count = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return count;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;  // + fix null check

        int pestanga = root.left  != null ?  longestpath(root.left , 0)  : 0;
        int pedreapta = root.right != null ?  longestpath(root.right, 0) : 0;

        count = Math.max(count, pedreapta + pestanga);

        dfs(root.left);   // + recursie
        dfs(root.right);  // + recursie
    }

    public int longestpath(TreeNode root, int c) {
        if (root == null) return c;
        return Math.max(longestpath(root.left, c + 1), longestpath(root.right, c + 1)); // + Math.max
    }
}