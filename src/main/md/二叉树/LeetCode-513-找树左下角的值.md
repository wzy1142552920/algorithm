## LeetCode-513-找树左下角的值
### BFS - 层序遍历
```java
public int findBottomLeftValue(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int ans = 0;
    while (!queue.isEmpty()) {
        int size = queue.size();
        ans = queue.peek().val;
        for (int i = 0; i < size; i++) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }
    return ans;
}
```

### DFS
节点深度，前序遍历
```java
int maxHeight = 0;
int left = 0;
public int findBottomLeftValue(TreeNode root) {
    dfs(root, 1);
    return left;
}

private void dfs(TreeNode root, int depth) {
    if (root == null) {
        return;
    }
    if (depth > maxHeight) {
        left = root.val;
        maxHeight = depth;
    }
    dfs(root.left, depth + 1);
    dfs(root.right, depth + 1);
}
```