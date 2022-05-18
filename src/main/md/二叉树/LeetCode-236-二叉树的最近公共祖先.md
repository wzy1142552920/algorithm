## LeetCode-236-二叉树的最近公共祖先
递归，后序遍历
```java
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) {
        return root;
    }
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    if (left == null && right == null) {
        return null;
    } else if (left != null && right == null) {
        return left;
    } else if (left == null && right != null) {
        return right;
    } else {
        return root;
    }
}
```