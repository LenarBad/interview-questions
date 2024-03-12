# Trees

## DFS (Deep First Search)

### DFS for Binary Trees

<details>
<summary><b>In-Order DFS</b></summary>

```java
private void dfs(TreeNode node) {
  if (node == null) return;
  dfs(node.left);
  // action
  dfs(node.left);
}
```
</details>
We can use in-order traversal for sorting BST (Binary Search Tree) nodes by values if _action_ is adding a node or node value to a list
<details>
<summary>Sort nodes example</summary>

```java
private void dfs(TreeNode node, List<Integer> sortedList) {
  if (node == null) return;
  dfs(node.left);
  sortedList.add(node.val);
  dfs(node.left);
}
```

</details

<details>
<summary><b>Pre-Order DFS</b></summary>

```java
private void dfs(TreeNode node) {
  if (node == null) return;
  // action
  dfs(node.left);
  dfs(node.left);
}
```
</details>

<details>
<summary><b>Post-Order DFS</b></summary>

```java
private void dfs(TreeNode node) {
  if (node == null) return;
  dfs(node.left);
  dfs(node.left);
  // action
}
```
</details>

1. [Max Path between Leaves](https://github.com/LenarBad/interview-questions/blob/main/trees/max-path-sum-between-leaves-in-beenary-tree.java)
2. [Max Depth of Binary Tree](https://github.com/LenarBad/interview-questions/blob/main/trees/max-depth-of-binary-tree.java)
3. [Binary Tree Level Order Traversal](https://github.com/LenarBad/interview-questions/blob/main/trees/tree-level-order-traversal.java) - [102. Leetcode](https://leetcode.com/problems/binary-tree-level-order-traversal/)
4. [Find Minimal Cost Leaf in a Tree](https://github.com/LenarBad/interview-questions/blob/main/trees/minimal-cost-leaf-in-tree.java)
5. [Kth Smallest Node in Binary Search Tree](https://github.com/LenarBad/interview-questions/blob/main/trees/kth-smallest-node-in-bst.java)
