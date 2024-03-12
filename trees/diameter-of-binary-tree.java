// Given the root of a binary tree, return the length of the diameter of the tree.
// The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
// The length of a path between two nodes is represented by the number of edges between them.

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        return diameter(root, 0);
    }
    
    private int diameter(TreeNode root, int maxSoFar) {
        if (root == null) {
            return maxSoFar;
        }
        
        int diameter = depth(root.left) + depth(root.right);
        int newMax = Math.max(maxSoFar, diameter);
      
        return Math.max(diameter(root.left, newMax), diameter(root.right, newMax));
    }
    
    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
    
        return Math.max(left, right) + 1;
    }
}
