class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);   // ← reconstruiești legătura
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key); // ← reconstruiești legătura
        } else {
            // găsit — cele 4 cazuri
            if (root.left == null && root.right == null) return null;
            if (root.left == null)  return root.right;
            if (root.right == null) return root.left;

            // doi copii
            TreeNode pred = insuc(root);
            root.val = pred.val;
            root.left = deleteNode(root.left, pred.val); // ← ștergi pred.val, nu key
        }

        return root;
    }

    public TreeNode insuc(TreeNode root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }
}