// @algorithm @lc id=774 lang=java 
// @title maximum-depth-of-n-ary-tree

package _559_Maximum_Depth_of_N_ary_Tree;
// @test([1,null,3,2,4,null,5,6])=3

// @test([1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14])=5
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution递归 {
    public int maxDepth(Node root) {
        return maxDepthRecursion(root);
    }

    int maxDepthRecursion(Node node) {
        if (node == null) {
            return 0;
        }
        int depth = 0;
        if (node.children != null) {
            for (Node child : node.children) {
                depth = Math.max(
                        depth, maxDepthRecursion(child));
            }
        }
        return depth + 1;
    }
}