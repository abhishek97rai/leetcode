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
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left == null && right == null)
            return true;
        else if (left == null || right == null)
            return false;
        boolean isNodeSymm = false;
        return compare(left, right);
    }

    public boolean compare(TreeNode left, TreeNode right) {
        boolean isEqual = false;
        if (left == null && right == null)
            return true;
        else if (left == null || right == null)
            return false;
        if (left.val == right.val)
            isEqual = true;
        return isEqual && compare(left.left, right.right) && compare(left.right, right.left);
    }
}
