# Trees

## DFS (Deep First Search)
DFS - good for "visiting" leaves of a tree

### DFS for Binary Trees

#### In-Order DFS
```java
private void dfs(TreeNode node) {
  if (node == null) return;
  dfs(node.left);
  // do something with the node;
  dfs(node.left);
}
```


1. [Max Path between Leaves](https://github.com/LenarBad/interview-questions/blob/main/trees/max-path-sum-between-leaves-in-beenary-tree.java)
2. [Max Depth of Binary Tree](https://github.com/LenarBad/interview-questions/blob/main/trees/max-depth-of-binary-tree.java)
3. [Binary Tree Level Order Traversal](https://github.com/LenarBad/interview-questions/blob/main/trees/tree-level-order-traversal.java) - [102. Leetcode](https://leetcode.com/problems/binary-tree-level-order-traversal/)
4. [Find Minimal Cost Leaf in a Tree](https://github.com/LenarBad/interview-questions/blob/main/trees/minimal-cost-leaf-in-tree.java)
5. [Kth Smallest Node in Binary Search Tree](https://github.com/LenarBad/interview-questions/blob/main/trees/kth-smallest-node-in-bst.java)
