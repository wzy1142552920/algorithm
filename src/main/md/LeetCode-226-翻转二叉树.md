## LeetCode-226-翻转二叉树
递归的方法，前序遍历
```java
public TreeNode invertTree(TreeNode root) {
    if (root == null) {
        return null;
    }
    TreeNode leftNode = invertTree(root.left);
    TreeNode rightNode = invertTree(root.right);
    root.left = rightNode;
    root.right = leftNode;
    return root;
}
```