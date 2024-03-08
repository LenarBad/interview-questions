    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while (!q.isEmpty()) {
            int numberOfNodeAtLevel = q.size();
            List<Integer> levelList = new ArrayList();
            // Iterate through all the current level nodes in the queue
            for (int i = 0; i < numberOfNodeAtLevel; i++) {
                TreeNode cur = q.poll();
                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                }
                levelList.add(cur.val);
            }
            result.add(levelList);
        }
        return result;
    }
