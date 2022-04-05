## LeetCode-701-二叉搜索树中的插入操作
递归有返回值
```java
public TreeNode insertIntoBST(TreeNode root, int val) {
    if (root == null) {
        return new TreeNode(val);
    }
    if (root.val > val) {
        root.left = insertIntoBST(root.left, val);
    } else {
        root.right = insertIntoBST(root.right, val);
    }
    return root;
}
```

递归没有返回值
```java
public TreeNode insertIntoBST(TreeNode root, int val) {
    TreeNode rootCpy = root;
    if (root == null) {
        return new TreeNode(val);
    }
    insert(root, val);
    return rootCpy;
}

private void insert(TreeNode root, int val) {
    if (root.val > val) {
        if (root.left == null) {
            root.left = new TreeNode(val);
            return;
        } else {
            insert(root.left, val);
        }
    } else {
        if (root.right == null) {
            root.right = new TreeNode(val);
            return;
        } else {
            insert(root.right, val);
        }
    }
}
```