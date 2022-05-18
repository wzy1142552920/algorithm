## LeetCode-530-二叉搜索树的最小绝对差
中序遍历，相邻两个差值的最小值
```java
int ans = Integer.MAX_VALUE;
TreeNode pre;

public int getMinimumDifference(TreeNode root) {
    if (root == null) {
        return 0;
    }
    travel(root);
    return ans;
}

private void travel(TreeNode root) {
    if (root == null) {
        return;
    }
    travel(root.left);
    if (pre != null) {
        ans = Math.min(ans, Math.abs(pre.val - root.val));
    }
    pre = root;
    travel(root.right);
}
```