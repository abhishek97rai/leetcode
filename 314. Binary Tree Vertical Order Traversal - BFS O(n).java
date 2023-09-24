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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        Map<Integer, List<Integer>> hm = new HashMap<>();
        queue.add(root);
        cols.add(0);
        
        int min = 0;
        int max = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int col = cols.poll();
            if (!hm.containsKey(col)) {
                hm.put(col, new ArrayList<Integer>());
            }
            hm.get(col).add(node.val);

            if (node.left != null) {
                queue.add(node.left);
                cols.add(col-1);
                min = Math.min(min, col-1);
            }
            if (node.right != null) {
                queue.add(node.right);
                cols.add(col+1);
                max = Math.max(max, col+1);
            }
        }

        for (int i = min; i <= max; i++) {
            res.add(hm.get(i));
        }

        return res;
    }
}
