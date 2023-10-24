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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> nodeQ = new LinkedList<>();
        Queue<Integer> colsQ = new LinkedList<>();
        Map<Integer, List<Integer>> hm = new HashMap<>();
        int min = 0;
        int max = 0;
        nodeQ.add(root);
        colsQ.add(0);
        while (!nodeQ.isEmpty()) {
            int size = nodeQ.size();
            Map<Integer, List<Integer>> tmp = new HashMap<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodeQ.poll();
                int col = colsQ.poll();
                List<Integer> list;
                if (!tmp.containsKey(col)) {
                    list = new ArrayList<>();
                } else {
                    list = tmp.get(col);
                }
                list.add(node.val);
                tmp.put(col, list);
                if (node.left != null) {
                    nodeQ.add(node.left);
                    colsQ.add(col-1);
                    min = Math.min(min, col-1);
                }
                if (node.right != null) {
                    nodeQ.add(node.right);
                    colsQ.add(col+1);
                    max = Math.max(max, col+1);
                }
            }
            for (Map.Entry<Integer, List<Integer>> set: tmp.entrySet()) {
                List<Integer> list = set.getValue();
                Collections.sort(list);
                List<Integer> existingList = hm.getOrDefault(set.getKey(), new ArrayList<>());
                existingList.addAll(list);
                hm.put(set.getKey(), existingList);
            }
        }
        for (int i = min; i <= max; i++) {
            res.add(hm.get(i));
        }
        return res;
    }
}
