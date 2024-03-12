# Trees

## General Info

<details>
<summary>Show</summary>

  ## DFS (Deep First Search)

  In-Order/Pre-Order/Post-Order DFS
  
  ```java
  private void inOrderDfs(TreeNode node) {
    if (node == null) return;
    inOrderDfs(node.left);
    // action
    inOrderDfs(node.left);
  }
  
  private void preOrderDfs(TreeNode node) {
    if (node == null) return;
    // action
    preOrderDfs(node.left);
    preOrderDfs(node.left);
  }
  
  private void postOrderDfs(TreeNode node) {
    if (node == null) return;
    postOrderDfs(node.left);
    postOrderDfs(node.left);
    // action
  }
  ```
  
 Sort nodes example
  
  ```java
  List<Integer> list = new ArrayList();
  dfs(root, list);
  
  private void dfs(TreeNode node, List<Integer> sortedList) {
    if (node == null) return;
    dfs(node.left);
    sortedList.add(node.val);
    dfs(node.left);
  }
  ```

## BFS (Breath first Search)

```java
public void printAllNodes(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
        int nodesInCurrentLevel = queue.size();

        for (int i = 0; i < nodesInCurrentLevel; i++) {
            TreeNode node = queue.remove();
            // Action
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }
}
```

</details


## Problems

1. [Max Path between Leaves](https://github.com/LenarBad/interview-questions/blob/main/trees/max-path-sum-between-leaves-in-beenary-tree.java)
2. [Max Depth of Binary Tree](https://github.com/LenarBad/interview-questions/blob/main/trees/max-depth-of-binary-tree.java)
3. [Binary Tree Level Order Traversal](https://github.com/LenarBad/interview-questions/blob/main/trees/tree-level-order-traversal.java) - [102. Leetcode](https://leetcode.com/problems/binary-tree-level-order-traversal/)
4. [Find Minimal Cost Leaf in a Tree](https://github.com/LenarBad/interview-questions/blob/main/trees/minimal-cost-leaf-in-tree.java)
5. [Kth Smallest Node in Binary Search Tree](https://github.com/LenarBad/interview-questions/blob/main/trees/kth-smallest-node-in-bst.java)
