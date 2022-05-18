## LeetCode-114-二叉树的最大深度
### DFS
深度优先遍历
```java
public int maxDepth(TreeNode root) {
    if (root == null) {
        return 0;
    }
    int maxHeightLeft = maxDepth(root.left);
    int maxHeightRight = maxDepth(root.right);
    return 1 + Math.max(maxHeightLeft, maxHeightRight);
}
```
### BFS
二叉树层序遍历
```java
public int maxDepth(TreeNode root) {
    int ans = 0;
    if (root == null) {
        return ans;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
        int size = queue.size();
        ans++;
        for (int i = 0; i < size; i++) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
    }
    return ans;
}
```
