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
class BSTIterator {

    List<Integer> nums;
    int currIndex;

    public BSTIterator(TreeNode root) {
        this.nums = new ArrayList<>();
        inorder(root);
        this.currIndex = -1;
    }

    public void inorder(TreeNode node) {
        if (node == null)
            return;
        inorder(node.left);
        nums.add(node.val);
        inorder(node.right);
    }
    
    public int next() {
        this.currIndex++;
        return nums.get(currIndex);
    }
    
    public boolean hasNext() {
        if (this.currIndex < this.nums.size()-1) {
            return true;
        } else {
            return false;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
