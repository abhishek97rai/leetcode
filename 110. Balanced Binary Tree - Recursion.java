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
    public boolean isBalanced(TreeNode root) {
        //if height of left sub tree and right sub tree of a node differ by <=1,
        //then that node is balanced
        //a binary tree where all nodes satisfy this is called a balanced binary tree
        if (root == null || (root.left == null && root.right == null))
            return true;
        int lHeight = heightCount(root.left);
        int rHeight = heightCount(root.right);
        if ((Math.abs(lHeight - rHeight) <= 1) && isBalanced(root.left) && 
        isBalanced(root.right))
            return true;
        else
            return false;
    }

    public int heightCount(TreeNode node) {
        if (node == null)
            return 0;
        int lHeight = heightCount(node.left);
        int rHeight = heightCount(node.right);
        return Math.max(lHeight, rHeight) + 1;
    }
}
