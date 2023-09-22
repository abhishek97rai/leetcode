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
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        double min = Double.MAX_VALUE;
        int res = root.val;
        for (int num: nums) {
            double diff = Math.abs(target - num);
            if (diff < min) {
                res = num;
                min = diff;
            }
        }
        return res;
    }

    public void inorder(TreeNode node, List<Integer> nums) {
        if (node == null)
            return;
        inorder(node.left, nums);
        nums.add(node.val);
        inorder(node.right, nums);
    }
}
