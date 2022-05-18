## LeetCode-112-路径总和
### 深度优先遍历 
```java
int sum = 0;
public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) {
        return false;
    }
    return dfs(root, targetSum, sum);
}

private boolean dfs(TreeNode root, int targetSum, int sum) {
    if (root.left == null && root.right == null) {
        if (targetSum == sum + root.val) {
            return true;
        }
    }
    boolean left = false;
    if (root.left != null) {
        left = dfs(root.left, targetSum, sum + root.val);
    }
    boolean right = false;
    if (root.right != null) {
        right = dfs(root.right, targetSum, sum + root.val);
    }
    return left || right;
}
```

## LeetCode-113-路径总和
将已访问的节点值从target中减掉，当访问到叶子节点时，如果此时target和当前节点值相等，则满足
```java
public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<List<Integer>> ans = new ArrayList<>();
    if (root == null) {
        return ans;
    }
    List<Integer> path = new ArrayList<>();
    dfs(ans, path, root, targetSum);
    return ans;
}

private void dfs(List<List<Integer>> ans, List<Integer> path, TreeNode root, int targetSum) {
    path.add(root.val);
    if (root.left == null && root.right == null) {
        if (targetSum == root.val) {
            ans.add(new ArrayList<>(path));//保存结果需要复制一份
        } else {
            return;
        }
    }
    if (root.left != null) {
        dfs(ans, path, root.left, targetSum - root.val);
        path.remove(path.size() - 1);
    }
    if (root.right != null) {
        dfs(ans, path, root.right, targetSum - root.val);
        path.remove(path.size() - 1);
    }
}
```
