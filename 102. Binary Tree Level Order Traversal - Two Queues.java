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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null)
            return resList;
        LinkedList<TreeNode> q1 = new LinkedList<>();
        LinkedList<TreeNode> q2 = new LinkedList<>();
        q1.add(root);
        List<Integer> currLevel = new ArrayList<>();
        currLevel.add(root.val);
        resList.add(currLevel);
        while (q1.size() != 0 || q2.size() != 0) {
            if (q1.size() == 0) {
                currLevel = new ArrayList<>();
                for (TreeNode node: q2) {
                    currLevel.add(node.val);
                }
                resList.add(currLevel);
                q1 = q2;
                q2 = new LinkedList<>();
            }
            TreeNode node = q1.poll();
            if (node.left != null)
                q2.add(node.left);
            if (node.right != null)
                q2.add(node.right);
        }
        return resList;
    }
}
