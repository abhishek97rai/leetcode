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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        LinkedList<TreeNode> queue1 = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();
        res.add(root.val);
        queue1.add(root);
        while (queue1.size() != 0) {
            TreeNode node = queue1.poll();
            if (node.left != null)
                queue2.add(node.left);
            if (node.right != null)
                queue2.add(node.right);
            if (queue1.size() == 0 && queue2.size() != 0) {
                //add rightmost element in queue2 to resList
                res.add(queue2.getLast().val);
                queue1 = (LinkedList) queue2.clone();
                queue2.clear();
            }
        }
        return res;
    }

}
