## LeetCode-700-二叉搜索树中的搜索
```java
public TreeNode searchBST(TreeNode root, int val) {
    if (root == null || root.val == val) {
        return root;
    }
    if (root.val > val) {
        return searchBST(root.left, val);
    } else {
        return searchBST(root.right, val);
    }
}
```