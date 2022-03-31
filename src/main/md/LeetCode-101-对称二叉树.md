## LeetCode-101-对称二叉树
递归的方法

判断左右子树是否对称
```java
public boolean isSymmetric(TreeNode root) {
    if (root == null) {
        return true;
    }
    return compare(root.left, root.right);
}

private boolean compare(TreeNode left, TreeNode right) {
    if (left == null && right == null) {
        return true;
    } else if (left != null && right != null && left.val == right.val) {
        return compare(left.left, right.right) && compare(left.right, right.left);
    } else {
        return false;
    }
}
```