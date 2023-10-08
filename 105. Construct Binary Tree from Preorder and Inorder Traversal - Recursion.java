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

    public int preorderIndex;
    public Map<Integer,Integer> inorderMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return arrayToTree(preorder, 0, inorder.length-1);
    }

    public TreeNode arrayToTree(int[] preorder, int left, int right) {
        if (left > right)
            return null;
        TreeNode node = new TreeNode(preorder[preorderIndex]);
        preorderIndex++;
        node.left = arrayToTree(preorder, left, inorderMap.get(node.val)-1);
        node.right = arrayToTree(preorder, inorderMap.get(node.val)+1, right);
        return node;
    }
}
