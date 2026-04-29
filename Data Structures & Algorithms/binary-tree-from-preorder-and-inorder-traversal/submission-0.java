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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder , inorder , 0 , preorder.length-1 ,  0, inorder.length-1);
    }
    public TreeNode build(int[] preorder , int[] inorder, int si , int ei , int sp , int ep){
        if (si > ei || sp > ep) return null;
        int root = preorder[sp];
        TreeNode curr = new TreeNode(root);
        
        int m = si;
        while(inorder[m]!=root){
            m++;
        }
        int leftsize = m-si;


        curr.left = build(preorder,inorder, si , m-1 , sp+1 , sp+leftsize);
        curr.right = build(preorder , inorder , m+1 , ei , sp+leftsize+1 , ep);
        return curr;
    }
}
