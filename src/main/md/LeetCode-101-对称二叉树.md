## LeetCode-101-对称二叉树
### 递归方法

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

### 迭代方法
```java
public boolean isSameTree(TreeNode p, TreeNode q) {
    Queue<TreeNode> queueQ = new LinkedList<>();
    Queue<TreeNode> queueP = new LinkedList<>();
    queueP.add(p);
    queueQ.add(q);
    while (!queueP.isEmpty() && !queueQ.isEmpty()) {
        TreeNode curP = queueP.poll();
        TreeNode curQ = queueQ.poll();
        if (curP == null && curQ == null) {
            continue;
        }
        if (curP != null && curQ != null && curP.val == curQ.val) {
            queueP.add(curP.left);
            queueP.add(curP.right);
            queueQ.add(curQ.left);
            queueQ.add(curQ.right);
        } else {
            return false;
        }
    }
    return true;
}
```
