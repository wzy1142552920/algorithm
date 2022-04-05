## LeetCode-701-二叉搜索树中的插入操作
二叉搜索树插入，可以不考虑结构调整，找到满足条件的空节点插入即可
### 迭代法
```java
public TreeNode insertIntoBST(TreeNode root, int val) {
    if (root == null) {
        return new TreeNode(val);
    }
    TreeNode parent = root;
    TreeNode cur = root;
    while (cur != null) {
        parent = cur;
        if (cur.val > val) {
            cur = cur.left;
        } else {
            cur = cur.right;
        }
    }
    if (parent.val > val) {
        parent.left = new TreeNode(val);
    } else {
        parent.right = new TreeNode(val);
    }
    return root;
}
```

### 递归有返回值
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

### 递归没有返回值
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