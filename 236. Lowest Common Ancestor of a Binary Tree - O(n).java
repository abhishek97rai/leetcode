/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode lTree = lowestCommonAncestor(root.left, p, q);
        TreeNode rTree = lowestCommonAncestor(root.right, p, q);
        if (lTree == null && rTree == null)
            return null;
        if (lTree != null && rTree != null)
            return root;
        if (lTree == null)
            return rTree;
        else
            return lTree;
    }
}
