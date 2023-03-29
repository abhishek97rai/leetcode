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
        if (root == null)
            return root;
        int value = root.val;
        if (key < value)
            root.left = deleteNode(root.left, key);
        else if (key > value)
            root.right = deleteNode(root.right, key);
        else {
            if (root.left == null && root.right == null)
                root = null;
            else if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            else {
                TreeNode minNode = findMin(root.right);
                root.val = minNode.val;
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
        //while swapping child, check if that child has both its own children as null, then delete connection from main parent and child, if not, then swap it
    }

    public TreeNode findMin(TreeNode node) {
        TreeNode res = node;
        while (res.left != null)
            res = res.left;
        return res;
    }
}
