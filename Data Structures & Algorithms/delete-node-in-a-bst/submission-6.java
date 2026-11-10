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
    public TreeNode deleteNode(TreeNode root, int key) {
        return delete(root , key);
    }

    private TreeNode delete(TreeNode root , int key){  
        if (root == null) return null;   
        if(root.val == key){
            if(root.left == null && root.right == null){
                return null;
            }else if(root.left==null && root.right != null){
                return root.right;
            }else if(root.left!=null && root.right == null){
                return root.left;
            }else{
                TreeNode piv = root.right.left;
                if(piv == null){
                    root.right.left = root.left;
                    return delete(root.right , key);
                }else{
                    while(piv.left!=null){
                        piv = piv.left;
                    }
                    root.val = piv.val;
                    root.right =  delete(root.right , piv.val);
                }
                
            }
        }
        if(root.val > key){
            root.left = delete(root.left , key);
        }else{
            root.right = delete(root.right , key);
        }


        return root;

    }
}