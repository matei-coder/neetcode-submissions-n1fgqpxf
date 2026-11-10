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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        String pathP = path(root , p);
        String pathQ = path(root , q);
        int i = 0;
        while(i<pathP.length() && i<pathQ.length()&&
        pathP.charAt(i) == pathQ.charAt(i)){
            i++;
        }
        return findLCS(root , pathP.substring(0 , i) , 0);

    }
    private String path(TreeNode root , TreeNode p){
        if(root.val == p.val) return "";
        else if(p.val < root.val){
            return "l" + path(root.left , p);
        }else{
            return "r" + path(root.right , p);
        }
    }
    private TreeNode findLCS(TreeNode root , String s, int ix){   
        if(ix == s.length()){
            return root;
        }
        char dir = s.charAt(ix);
        if(dir == 'l') return findLCS(root.left , s , ix+1);
        else return findLCS(root.right , s , ix+1);

        
    }
}
