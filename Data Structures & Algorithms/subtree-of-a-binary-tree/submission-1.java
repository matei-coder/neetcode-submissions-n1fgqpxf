class Solution {  
    boolean ans = false; // schimbat în false

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        dfs(root, subRoot);
        return ans;
    }

    public void dfs(TreeNode root, TreeNode subRoot) {
        if(ans == true) return;
        if (root == null) return;
        if (comparetoroot(root, subRoot)) ans = true; // setezi true doar la match
        dfs(root.left, subRoot);
        dfs(root.right, subRoot);
    }

    public boolean comparetoroot(TreeNode root, TreeNode subroot) { // returneaza boolean
        if (root == null && subroot == null) return true;
        if (root == null || subroot == null) return false;
        if (root.val != subroot.val) return false;
        return comparetoroot(root.left, subroot.left) && comparetoroot(root.right, subroot.right);
    }
}