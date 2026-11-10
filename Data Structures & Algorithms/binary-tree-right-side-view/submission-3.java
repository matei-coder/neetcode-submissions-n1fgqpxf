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
    public List<Integer> rightSideView(TreeNode root) {
       
   
        List<Integer> ans= new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            
            List<Integer> currList = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(curr==null) continue;
                currList.add(curr.val);
                q.add(curr.right);
                q.add(curr.left);
            }
            
            if(!currList.isEmpty())
            ans.add(currList.get(0));
        }

        return ans;
  
    }
}
