    private int max = Integer.MIN_VALUE;
    public int maxSumBeetweenLeaves(TreeNode root) {
        maxSum(root);
    }

    private int maxSum(TreeNode node) {
        if (node == null) return;
        int leftSum = maxSum(node.left);
        int rightSum = maxSum(node.right);
        if (max < leftSum + rightSum + node.val) {
            max = leftSum + rightSum + node.val;
        }
    }
