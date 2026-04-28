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
    public int kthSmallest(TreeNode root, int k) {
        for(int i=0;i<k-1;i++){
            TreeNode temp = root;
            root = deleteNode(root , findsmallest(temp));

        }
        return findsmallest(root);
    }

    public int findsmallest(TreeNode root){
        while(root.left!=null){
            root=root.left;
        }
        return root.val;
    }

    public TreeNode deleteNode(TreeNode root , int key){
        if(root== null) return null;
        if(key<root.val) root.left = deleteNode(root.left , key);
        else if(key>root.val) root.right = deleteNode(root.right , key);
        else{
            if(root.left==null&&root.right==null) return null;
            if(root.left!=null&&root.right==null) return root.left;
            if(root.left==null&&root.right!=null) return root.right;
            TreeNode temp = findin(root);
            root.val = temp.val;
            root.left = deleteNode(root.left , temp.val );


            


        }
        return root;
    }

    public TreeNode findin(TreeNode root){
        root=root.left;
        while(root.right!=null) root = root.right;
        return root;
    }
}
