## LeetCode-257-二叉树的所有路径
### 递归方法DFS
```java
public List<String> binaryTreePaths(TreeNode root) {
    List<String> ans = new ArrayList<>();
    if (root == null) {
        return ans;
    }
    List<Integer> path = new ArrayList<>();
    process(ans, path, root);
    return ans;
}

private void process(List<String> ans, List<Integer> path, TreeNode root) {
    path.add(root.val);
    if (root.left == null && root.right == null) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < path.size(); i++) {
            if (i == path.size() - 1) {
                stringBuilder.append(path.get(i));
            } else {
                stringBuilder.append(path.get(i)).append("->");
            }
        }
        ans.add(stringBuilder.toString());
        return;
    }
    if (root.left != null) {
        process(ans, path, root.left);
// 回溯，恢复现场
        path.remove(path.size() - 1);
    }
    if (root.right != null) {
        process(ans, path, root.right);
// 回溯，恢复现场
        path.remove(path.size() - 1);
    }
}
```

### 迭代方法
```java
public List<String> binaryTreePaths2(TreeNode root) {
    List<String> ans = new ArrayList<>();
    if (root == null) {
        return ans;
    }
    Stack<TreeNode> stack = new Stack<>();
    Stack<String> paths = new Stack<>();
    stack.push(root);
    paths.add(root.val + "");
    while (!stack.isEmpty()) {
        TreeNode cur = stack.pop();
        String path = paths.pop();
        if (cur.left == null && cur.right == null) {
            ans.add(path);
        }
        if (cur.left != null) {
            stack.push(cur.left);
            paths.push(path + "->" + cur.left.val);
        }
        if (cur.right != null) {
            stack.push(cur.right);
            paths.push(path + "->" + cur.right.val);
        }
    }
    return ans;
}
```
### BFS
```java
public List<String> binaryTreePaths3(TreeNode root) {
    List<String> ans = new ArrayList<>();
    if (root == null) {
        return ans;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    Queue<StringBuilder> paths = new LinkedList<>();
    queue.add(root);
    paths.add(new StringBuilder(root.val + ""));
    while (!queue.isEmpty()) {
        TreeNode cur = queue.poll();
        StringBuilder path = paths.poll();
        if (cur.left == null && cur.right == null) {
            ans.add(path.toString());
        }
        if (cur.left != null) {
            queue.add(cur.left);
            paths.add(new StringBuilder(path).append("->").append(cur.left.val));
        }
        if (cur.right != null) {
            queue.add(cur.right);
            paths.add(new StringBuilder(path).append("->").append(cur.right.val));
        }
    }
    return ans;
}
```