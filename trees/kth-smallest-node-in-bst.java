class Solution {
    private int count = 0;
    private int result;
  
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return result;
    }

    private void dfs(TreeNode node, int k) {
        if (node.left != null) {
            dfs(node.left, k);
        }
        count++;
        if (count == k) {
            result = node.val; 
            return;
        } 
        if (node.right != null) {
            dfs(node.right, k);
        }
    }

}
