## LeetCode-897-递增顺序搜索树
```java
TreeNode pre;
TreeNode cur;
TreeNode ans;
public TreeNode increasingBST(TreeNode root) {
    travel(root);
    return ans;
}

private void travel(TreeNode root) {
    if (root == null) {
        return;
    }
    travel(root.left);
    if (pre == null) {
        ans = new TreeNode(root.val);
        cur = ans;
    } else {
        cur.right = new TreeNode(root.val);
        cur = cur.right;
    }
    pre = root;
    travel(root.right);
}
```