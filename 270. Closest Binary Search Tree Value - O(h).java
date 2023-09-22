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
        
    public int closestValue(TreeNode root, double target) {
        double min = Double.MAX_VALUE;
        int res = root.val;
        double diff = 0;
        while (root != null) {
            if (root.val == target)
                return root.val;
            diff = Math.abs(root.val - target);
            if (diff < min) {
                res = root.val;
                min = diff;
            } else if (diff == min) {
                res = Math.min(res, root.val);
                min = diff;
            }
            if (target < root.val)
                root = root.left;
            else
                root = root.right;
        }    
        return res;
    }

}
