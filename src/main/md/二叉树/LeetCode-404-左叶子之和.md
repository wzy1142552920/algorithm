## LeetCode-404-左叶子之和
### DFS递归
```java
public int sumOfLeftLeaves(TreeNode root) {
    if (root == null) {
        return 0;
    }
    return process(root.left, true) + process(root.right, false);
}

private int process(TreeNode root, boolean isLeft) {
    if (root == null) {
        return 0;
    }
    if (isLeft) {
        if (root.left == null && root.right == null) {
            return root.val;
        }
    }
    int sum = 0;
    if (root.left != null) {
        sum += process(root.left, true);
    }
    if (root.right != null) {
        sum += process(root.right, false);
    }
    return sum;
}
```
### BFS
```java
public int sumOfLeftLeaves(TreeNode root) {
    if (root == null) {
        return 0;
    }

    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);
    int ans = 0;
    while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        if (node.left != null) {
            if (isLeafNode(node.left)) {
                ans += node.left.val;
            } else {
                queue.offer(node.left);
            }
        }
        if (node.right != null) {
            if (!isLeafNode(node.right)) {
                queue.offer(node.right);
            }
        }
    }
    return ans;
}

public boolean isLeafNode(TreeNode node) {
    return node.left == null && node.right == null;
}
```