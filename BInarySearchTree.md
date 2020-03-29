## Binary Search Tree
fact https://leetcode.com/articles/delete-node-in-a-bst/

1. Inorder traversal of BST is an array sorted in the ascending order.
2. Successor = "after node", i.e. the next node, or the smallest node after the current one.
It's also the next node in the inorder traversal. To find a successor, go to the right once and then as many times to the left as you could.

```Java
public int successor(TreeNode root) {
  root = root.right;
  while (root.left != null) root = root.left;
  return root;
} 
```
3. Predecessor = "before node", i.e. the previous node, or the largest node before the current one.
```Java
public int predecessor(TreeNode root) {
  root = root.left;
  while (root.right != null) root = root.right;
  return root;
} 
```



