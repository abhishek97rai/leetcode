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
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = sortedArrayToBST(nums, 0, nums.length-1);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left <= right) {
            int mid = (left+right)/2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = sortedArrayToBST(nums, left, mid-1);
            node.right = sortedArrayToBST(nums, mid+1, right);
            return node;
        } else {
            return null;
        }
    }
}
