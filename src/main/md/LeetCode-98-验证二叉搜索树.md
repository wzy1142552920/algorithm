## LeetCode-98-验证二叉搜索树
不能只判断左右节点和根节点的大小关系
### 递归
```java
public boolean isValidBST(TreeNode root) {
    return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
}

private boolean isValid(TreeNode root, long lower, long upper) {
    if (root == null) {
        return true;
    }
    if (root.val <= lower || root.val >= upper) {
        return false;
    }
    return isValid(root.left, lower, root.val) && isValid(root.right, root.val, upper);
}
```

### 中序遍历
中序遍历，看遍历结果是否为递增序列