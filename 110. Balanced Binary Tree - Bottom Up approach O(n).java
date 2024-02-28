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

class TreeNodeInfo {
    int height;
    boolean balanced;

    TreeNodeInfo(int height, boolean balanced) {
        this.height = height;
        this.balanced = balanced;
    }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        return isBalancedHelper(root).balanced;
    }

    public TreeNodeInfo isBalancedHelper(TreeNode node) {
        if (node == null)
            return new TreeNodeInfo(0, true);
        
        TreeNodeInfo lTreeInfo = isBalancedHelper(node.left);
        if (!lTreeInfo.balanced) {
            return new TreeNodeInfo(0, false);
        }

        TreeNodeInfo rTreeInfo = isBalancedHelper(node.right);
        if (!rTreeInfo.balanced) {
            return new TreeNodeInfo(0, false);
        }

        if (Math.abs(lTreeInfo.height - rTreeInfo.height) > 1) {
            return new TreeNodeInfo(0, false);
        } else {
            int height = 1 + Math.max(lTreeInfo.height, rTreeInfo.height);
            return new TreeNodeInfo(height, true);
        }
    }
}
