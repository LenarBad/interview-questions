// the sum of values of its deepest leaves.
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int nodesInCurrentLevel = queue.size();
            sum = 0;

            for (int i = 0; i < nodesInCurrentLevel; i++) {
                TreeNode node = queue.remove();
                sum += node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return sum;
    }
}
