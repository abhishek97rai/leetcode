/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        int depthP = getDepth(p);
        int depthQ = getDepth(q);
        while (depthP < depthQ) {
            q = q.parent;
            depthQ--;
        }
        while (depthQ < depthP) {
            p = p.parent;
            depthP--;
        }
        while (p != q) {
            p = p.parent;
            q = q.parent;
        }
        return p;
    }

    public int getDepth(Node node) {
        int depth = 0;
        while (node != null) {
            depth++;
            node = node.parent;
        }
        return depth;
    }
}
