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

    public int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        int useless = heightCount(root);
        return max;
    }

    public int heightCount(TreeNode node) {
        if (node == null)
            return 0;
        TreeNode lNode = node.left;
        TreeNode rNode = node.right;
        int lHeight = heightCount(lNode);
        int rHeight = heightCount(rNode);
        max = Math.max(max, lHeight + rHeight);
        return Math.max(lHeight, rHeight) + 1;
    }
}
